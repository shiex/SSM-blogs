package com.xbb.controller;

import com.xbb.pojo.*;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    public static Random random = new Random();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired private ProgramaService programaService;
    @Autowired private ArticleService articleService;
    @Autowired private CommentService commentService;
    @Autowired private AppluadService appluadService;
    @Autowired private AttentionService attentionService;
    @Autowired private UserService userService;
    @Autowired private CollectService collectService;
    @Autowired RedisTemplate redisTemplate;

    @ModelAttribute("ctxPath")
    public String getCtxPath()
    {
        return StatusCode.CONTEXT_PATH;
    }

    @RequestMapping("/list/{id}")
    public String queryByArticleProgramaId(@PathVariable("id")int id, Model model)
    {
        List <Programa> list_programa = programaService.queryProgramaList();    // 分类列表
        List <Article> list_article = articleService.queryArticleList(id);  // 博客列表
        List <Article> articles = articleService.queryArticleReferral(id);    // 今日推荐
        if(articles.size() > 0){
            for(Article article : articles){
                if(article.getTitle().length() > 15){
                    int n = random.nextInt(15) + 7;
                    String title = article.getTitle().substring(0,n);
                    article.setTitle(title);
                }
            }
        }
        ArticleDateUtils.setDayTime(list_article);
        model.addAttribute("list_programa",list_programa);
        model.addAttribute("list_article", list_article);
        model.addAttribute("articles",articles);
        for(Programa programa : list_programa){
            if(programa.getId() == id){
                model.addAttribute("title", programa.getName());
            }
        }
        return "programa";
    }

    @RequestMapping("/issue.html")
    public String  issue() {
        return "article_add";
    }

    @RequestMapping("/edit/{id}.html")
    public String edit(@PathVariable("id")int id, Model model)
    {
        Article article = articleService.queryByIdArticle(id);
        model.addAttribute("article", article);
        return "article_add";
    }

    @RequestMapping(value = "/uploadFile",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> fileUpload(@RequestParam("file") MultipartFile multipartFile,
                                          HttpSession session)
    {
        Map<String, Object> map = RestMap.getRestMap();
        if(multipartFile != null)
        {
            // 原始文件名
            String realName = multipartFile.getOriginalFilename();
            // 文件名后缀
            String suffix = AfFileUploadUtils.fileSuffix(realName);

            // 判断文件是否为图片类型格式
            if(!StatusCode.IMG_TYPE.contains(suffix)){
                map.put("error", 1);
                map.put("message", "上传失败：请上传格式为[" + StatusCode.IMG_TYPE + "]的图片");
                return map;
            }
            if(multipartFile.getSize() > 10 * 1024 * 1024){
                map.put("error", 1);
                map.put("message","上传失败：图片大小不得超过10MB");
                return map;
            }
            // 生成保证不重复的临时文件名
            String tmpFileName = AfFileUploadUtils.createTmpFileName(suffix);
            // 存储位置父目录
            User user = (User) session.getAttribute("SESSION_USER");
            String imgsFileUrl = userService.findByIdImgsFile(user.getId()); // 图片存储父目录路径
            // 当图片数量大于1700时则新建文件夹
            File imgsFileRoot = new File(StatusCode.WEB_FILE_ROOT + imgsFileUrl);
            File[] files = imgsFileRoot.listFiles();
            if(files.length > 1700){
                String date = sdf.format(new Date());
                imgsFileUrl = StatusCode.USER_IMGS_ROOT + date + "/" + + user.getId();
                imgsFileRoot = new File(StatusCode.WEB_FILE_ROOT + imgsFileUrl);
                imgsFileRoot.mkdirs();
            }

            File tmpFile = new File(imgsFileRoot, tmpFileName);
            String imgUrl = StatusCode.CONTEXT_PATH + imgsFileUrl + "/" + tmpFileName;
            try{
                multipartFile.transferTo(tmpFile);
                map.put("error", 0);
                map.put("url", imgUrl);
            }catch (IOException e) {
                map.put("error", 1);
                map.put("message", e.getMessage());
                e.printStackTrace();
            }
        }

        return map;
    }

    // 添加博客
    @RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Article article, HttpSession session){
        Map<String, Object> map = RestMap.getRestMap();

        // 删除已上传并未提交的多余图片
        String imgUrls = article.getImgUrls();
        List<String> upload = KIndEditorUtils.getImgUrls(article.getContent(), StatusCode.CONTEXT_PATH);
        List<String> iuuse = KIndEditorUtils.getImgUrls(imgUrls, StatusCode.CONTEXT_PATH);
        KIndEditorUtils.removeImg(upload, iuuse, StatusCode.WEB_FILE_ROOT);

        // 截取部分文本作为博客摘要内容
        int n = random.nextInt(28) + 128;
        String synopsis = KIndEditorUtils.getText(article.getContent(),n) + "...";

        // 修改博客
        if(article.getId() != null){
            article.setIssue_time(new Date());
            articleService.updateArticle(article);
            map.put("data", "article/read/" + article.getId() + ".html");
            return map;
        }
        // 插入数据库
        User user = (User) session.getAttribute("SESSION_USER");
        article.setUser_id(user.getId());
        article.setSynopsis(synopsis);
        article.setIssue_time(new Date());
        article.setRead_count(0);
        articleService.add(article);
        userService.originalCountPlus(user.getId()); // 原创数量加1
        // redis：原创数量累计+1
        /*Map<String, Object> userMap = null;
        String userId = "userId_" + String.valueOf(user.getId());
        if(!redisTemplate.hasKey(userId))
        {
            userMap = new HashMap<>();
            userMap.put("original_count", user.getOriginal_count());
            userMap.put("fans", user.getFans());
            redisTemplate.opsForHash().putAll(userId, userMap);
            redisTemplate.expire(userId, 2, TimeUnit.HOURS);
        }
        redisTemplate.opsForHash().increment(userId, "original_count", 1);*/
        map.put("data", "article/read/" + article.getId() + ".html");
        return map;
    }

    // 点击阅读博客
    @RequestMapping("/read/{id}.html")
    public String read(@PathVariable("id") int id, Model model, HttpSession session){

        articleService.readCountPlus(id); // 阅读数加1
        Article article = articleService.queryArticleUser(id); // 当前博客数据
        List<Comment> list_comment = commentService.commentList(id);    // 评论
        List<Article> articles = articleService.queryHotArticle(article.getUser_id());    // 热门博客
        if(articles.size() > 0){
            model.addAttribute("articles", articles);
        }else {
            model.addAttribute("articles", null);
        }
        User user = (User) session.getAttribute("SESSION_USER");
        // 将用户是否存在点赞信息挂靠在评论的status
        if(list_comment.size() > 0){
            if(user != null){
                List<Appluad> list_appluad = appluadService.queryAppluads(id, user.getId());
                if(list_appluad.size() > 0){
                    for(Appluad appluad : list_appluad){
                        for(Comment comment : list_comment){
                            if(appluad.getComment_id() == comment.getId()){
                                if(appluad.getStatus()){
                                    comment.setStatus(1);
                                }
                            }
                        }
                    }
                }
            }
            model.addAttribute("list_comment", list_comment);
        }else {
            model.addAttribute("list_comment", null);
        }

        // 查询用户是否关注了此博主，1：已关注、0：未关注
        model.addAttribute("isFollow", 0);
        model.addAttribute("isCollect", 0);
        if(user != null){
            int isFollow = attentionService.findIsFollow(user.getId(), article.getUser_id()); // 判断是否关注
            int isCollect = collectService.findIsCollect(user.getId(),id); // 判断是否收藏
            model.addAttribute("isFollow", isFollow);
            model.addAttribute("isCollect", isCollect);
        }

        model.addAttribute("article", article);
        return "article_read";
    }

    // 用户个人页面初始化加载博客
    @RequestMapping("/init")
    @ResponseBody
    public Map articleInit(@RequestBody String userId){
        Map<String , Object> map = RestMap.getRestMap();
        List<Article> articles = articleService.queryUserArticles(Integer.valueOf(userId));
        for(Article article : articles){
            if(article.getTitle().length() > 36){
                article.setTitle(article.getTitle().substring(0,35) + "...");
            }
        }
        map.put("data", articles);
        return map;
    }

    // 删除博客
    @RequestMapping("/remove.do")
    @ResponseBody
    public Map remove(@RequestBody String articleId, HttpSession session){
        Map<String , Object> map = RestMap.getRestMap();
        // 判断是否原创，为原创则数量减1
        Boolean original = articleService.queryIsOriginal(articleId);
        if(original){
            User user = (User) session.getAttribute("SESSION_USER");
            userService.originalCountMinus(user.getId());
        }
        articleService.removeById(Integer.valueOf(articleId));
        return map;
    }

    // 修改置顶状态，由前端传递状态数据
    @RequestMapping("/stick")
    @ResponseBody
    public Map stick(@RequestBody Article article){
        Map<String , Object> map = RestMap.getRestMap();
        articleService.updateStick(article);  // 修改置顶状态
        return map;
    }

    // 顶部搜索按钮，在所有博客中进行查询
    @RequestMapping("/find/top/{antistop}")
    public String findArticles(@PathVariable("antistop") String antistop, Model model){
        List<Article> list_article = articleService.findArticles(antistop);
        ArticleDateUtils.setDayTime(list_article);
        model.addAttribute("list_article", list_article);
        return "article_find";
    }

    // 根据用户ID以及查询条件在用户发布博客中进行查找博客
    @RequestMapping("/find/user")
    @ResponseBody
    public Map findUserArticle(@RequestBody String antistop, HttpSession session){
        antistop = antistop.substring(1,antistop.length()-1);
        Map<String , Object> map = RestMap.getRestMap();
        User user = (User) session.getAttribute("SESSION_USER");
        List<Article> articles = articleService.findUserArticles(user.getId(),antistop);
        map.put("data", articles);
        return map;
    }

    /*
        添加博客生成对应的静态页面
     */
    /*@RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Article article, HttpSession session)
    {
        User user = (User) session.getAttribute("SESSION_USER");

        // 删除已上传并未提交的多余图片
        String imgUrls = article.getImgUrls();
        List<String> upload = KIndEditorUtils.getImgUrls(article.getContent(), StatusCode.CONTEXT_PATH);
        List<String> iuuse = KIndEditorUtils.getImgUrls(imgUrls, StatusCode.CONTEXT_PATH);
        KIndEditorUtils.removeImg(upload, iuuse, StatusCode.WEB_FILE_ROOT);

        // 截取部分文本作为博客摘要内容
        int n = random.nextInt(8) + 48;
        String synopsis = KIndEditorUtils.getText(article.getContent(),n) + "...";
        // 插入数据库
        article.setUser_id(user.getId());
        article.setSynopsis(synopsis);
        article.setIssue_time(new Date());
        article.setUsername(user.getUsername());
        article.setRead_count(0);
        articleService.add(article);

        // redis：原创数量累计+1
        Map<String, Object> userMap = null;
        String userId = "userId_" + String.valueOf(user.getId());
        if(!redisTemplate.hasKey(userId))
        {
            userMap = new HashMap<>();
            userMap.put("original_count", user.getOriginal_count());
            userMap.put("fans", user.getFans());
            redisTemplate.opsForHash().putAll(userId, userMap);
            redisTemplate.expire(userId, 2, TimeUnit.HOURS);
        }
        redisTemplate.opsForHash().increment(userId, "original_count", 1);

        // 生成静态页面
        String issueTime =  sdf.format(new Date());  // 生成存储目录
        File file = new File(StatusCode.WEB_FILE_ROOT + StatusCode.ARTICLE_ROOT, issueTime);
        file.mkdirs();

        String template = StatusCode.TEMPLATE_ROOT + "article_read.ftl";    // 模板路径
        String suffix = String.format("%d.html", article.getId());
        String htmlPath = StatusCode.ARTICLE_ROOT + issueTime + "/" + suffix; // 存储路径

        Map<String, Object> model = new HashMap<>(); // 数据源
        model.put("ctxPath", StatusCode.CONTEXT_PATH);
        model.put("article", article);
        model.put("list_comment", null);
        try{
            GenerateHtml.i.GenHtml(template , model, htmlPath);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 插入博客静态页面请求路径，去除头部的/
        articleService.updateHtmlPath(article.getId(),htmlPath.substring(1));
        model = RestMap.getRestMap();
        return model;
    }*/


}
