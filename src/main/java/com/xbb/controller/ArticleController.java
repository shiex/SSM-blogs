package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.User;
import com.xbb.service.*;
import com.xbb.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @title: 加载对应栏目的文章列表
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\11 001122:53
 */

@Controller
@RequestMapping("/article")
public class ArticleController{

    @Autowired private ArticleService articleService;
    @Autowired private UserService userService;
    @Autowired RedisTemplate redisTemplate;

    @ModelAttribute("ctxPath")
    public String getCtxPath()
    {
        return StatusCode.CONTEXT_PATH;
    }

    /**
     * @description: 发布博客页面
     * @param
     * @return: java.lang.String
     */
    @RequestMapping("/issue.html")
    public String  issue() {
        return "articleAdd";
    }

    /**
     * @description: 修改博客页面
     * @param articleId
     * @param model
     * @return: java.lang.String
     */
    @RequestMapping("/edit/{articleId}.html")
    public String edit(@PathVariable("articleId")int articleId, Model model, HttpSession session)
    {
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        Article article = articleService.query(articleId);
        if(article.getUserId() != user.getId())
            return "articleAdd";
        model.addAttribute("article", article);
        return "articleAdd";
    }

    /**
     * @description: 发布博客图片上传处理
     * @param multipartFile
     * @param session
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/uploadFile/{status}",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> fileUpload(@RequestParam("file") MultipartFile multipartFile,
                                          @PathVariable("status") int staus, HttpSession session)
    {
        Map<String, Object> map = RestMap.getRestMap();
        if(multipartFile != null)
        {
            String realName = multipartFile.getOriginalFilename(); // 原始文件名
            String suffix = AxFileUploadUtils.fileSuffix(realName); // 文件名后缀
            String tmpFileName = AxFileUploadUtils.createTmpFileName(suffix); // 生成保证不重复的临时文件名

            // 图片上传验证
            if(!StatusCode.IMG_TYPE.contains(suffix)){
                map.put(StatusCode.ERROR, 1);
                map.put(StatusCode.MESSAGE, "上传失败：请上传格式为[" + StatusCode.IMG_TYPE + "]的图片");
                return map;
            }
            if(multipartFile.getSize() > StatusCode.IMG_SIZE_MAX){
                map.put(StatusCode.ERROR, 1);
                map.put(StatusCode.MESSAGE,"上传失败：图片大小不得超过10MB");
                return map;
            }

            // // 当图片数量大于1900时则新建文件夹
            StringBuilder sbr = new StringBuilder();
            User user = (User) session.getAttribute(StatusCode.SESSION_USER);
            String imgFileRoot = user.getImgFileRoot(); // 图片存储父目录
            File imgFile = new File(StatusCode.WEB_FILE_ROOT,imgFileRoot);
            File[] files = imgFile.listFiles();
            if(files.length > 1900){
                String date = AxDateUtils.format(AxDateUtils.SDF_Y2);
                sbr.append(StatusCode.IMGS_ROOT).append(date).append("/").append(user.getId());
                imgFileRoot = sbr.toString();
                imgFile = new File(StatusCode.WEB_FILE_ROOT,imgFileRoot);
                imgFile.mkdirs(); // 生成图片存储新目录
            }

            File tmpFile = new File(imgFile, tmpFileName);
            sbr.setLength(0);
            sbr.append(StatusCode.CONTEXT_PATH).append(imgFileRoot).append("/").append(tmpFileName);
            try{
                multipartFile.transferTo(tmpFile); // 写入图片
                map.put(StatusCode.ERROR, 0); // 富文本编辑器图片上传成功状态码
                map.put("url", sbr.toString()); // 将图片路径返回于前端
            }catch (IOException e) {
                map.put(StatusCode.ERROR, 1); // 富文本编辑器图片上传失败状态码
                map.put(StatusCode.MESSAGE, e.getMessage());
                e.printStackTrace();
            }
        }

        return map;
    }

    /**
     * @description: id为null时添加博客，反之为修改
     * @param article
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Article article, HttpSession session){
        Map<String, Object> map = RestMap.getRestMap();

        // 删除已上传并未提交的多余图片
        String imgUrls = article.getImgUrls();
        List<String> upload = KIndEditorUtils.getImgUrls(article.getContent(), StatusCode.CONTEXT_PATH);
        List<String> iuuse = KIndEditorUtils.getImgUrls(imgUrls, StatusCode.CONTEXT_PATH);
        KIndEditorUtils.removeImg(upload, iuuse, StatusCode.WEB_FILE_ROOT);

        // 截取部分文本作为博客摘要内容以及显示标题
        int n1 = BlogsUtlis.random.nextInt(58) + 128;
        String synopsis = KIndEditorUtils.getText(article.getContent(),n1) + "...";
        article.setSynopsis(synopsis);
        article.setIssueTime(new Date());
        BlogsUtlis.setTitleShow(article); // 展示标题控制字数

        if(article.getId() == null){
            User user = (User) session.getAttribute(StatusCode.SESSION_USER);
            article.setUserId(user.getId());
            articleService.add(article);
            userService.originalCountPlus(user.getId()); // 原创数量加1
        }else {
            articleService.update(article);
        }

        // 返回请求路径
        map.put("data", String.format(StatusCode.ARTICLE_READ, article.getId()));
        return map;
    }

    /**
     * @description: 阅读博客页面
     * @param articleId
     * @param model
     * @param session
     * @return: java.lang.String
     */
    @RequestMapping("/read/{articleId}.html")
    public String read(@PathVariable("articleId") int articleId, Model model, HttpSession session){
        Article article = null;
        User u = (User) session.getAttribute(StatusCode.SESSION_USER);
        if(u == null){
            article = articleService.queryJoinTable(articleId, 0);
        }else {
            article = articleService.queryJoinTable(articleId, u.getId());
        }
        articleService.readCountPlus(articleId);
        User user = userService.queryHotArticle(article.getUserId());
        model.addAttribute("article", article);
        model.addAttribute("user", user);
        return "articleRead";
    }

    /**
     * @description: 删除博客
     * @param articleId
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/remove.do")
    @ResponseBody
    public Map remove(@RequestBody int articleId, HttpSession session){

        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        userService.originalCountMinus(user.getId());
        articleService.removeById(articleId);
        Map<String , Object> restMap = RestMap.getRestMap();
        return restMap;
    }

    /**
     * @description: 根据前端传递的状态修改置顶状态
     * @param article
     * @return: java.util.Map
     */
    @RequestMapping("/stick")
    @ResponseBody
    public Map stick(@RequestBody Article article){
        articleService.updateStick(article);  // 修改置顶状态
        Map<String , Object> restMap = RestMap.getRestMap();
        return restMap;
    }

    /**
     * @description: 全文模糊查询
     * @param antistop
     * @param model
     * @return: java.lang.String
     */
    @RequestMapping("/find/all/{antistop}")
    public String findArticles(@PathVariable("antistop") String antistop, Model model){
        List<Article> articleList = articleService.findFullText(antistop);
        BlogsUtlis.setDate(articleList);
        model.addAttribute("articleList", articleList);
        return "articleFind";
    }

    /**
     * @description: 用户发布博客模糊查询
     * @param antistop
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/find/user")
    @ResponseBody
    public Map findUserArticle(@RequestBody String antistop, HttpSession session){
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        List<Article> articleList = articleService.findUserIssue(user.getId(),antistop);
        Map<String , Object> restMap = RestMap.getRestMap();
        restMap.put("data", articleList);
        return restMap;
    }

}
