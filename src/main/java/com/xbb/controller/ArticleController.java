package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.User;
import com.xbb.service.ArticleService;
import com.xbb.service.UserService;
import com.xbb.utils.BlogsUtlis;
import com.xbb.utils.KIndEditorUtils;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
     * @description: id为null时添加博客，反之为修改
     * @param article
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map add(@RequestBody Article article, HttpSession session){
        Map<String, Object> map = RestMap.getRestMap();
        if(article.getTitle().length() > 100){
            RestMap.setRestMap(map, "标题请控制在100字数内!");
            return map;
        }

        // 删除已上传并未提交的多余图片
        String imgUrls = article.getImgUrls();
        List<String> upload = KIndEditorUtils.getImgUrls(article.getContent(), StatusCode.CONTEXT_PATH);
        List<String> iuuse = KIndEditorUtils.getImgUrls(imgUrls, StatusCode.CONTEXT_PATH);
        KIndEditorUtils.removeImg(upload, iuuse, StatusCode.WEB_FILE_ROOT);

        // 截取部分文本作为博客摘要内容以及显示标题
        String synopsis = KIndEditorUtils.getText(article.getContent(),0);
        if(synopsis.length() > 170){
            int n = BlogsUtlis.random.nextInt(78) + 98;
            synopsis = synopsis.substring(0, n);
        }
        BlogsUtlis.setTitleShow(article);
        article.setSynopsis(synopsis);
        article.setIssueTime(new Date());

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
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        if(user == null){
            article = articleService.queryJoinTable(articleId, 0);
        }else {
            article = articleService.queryJoinTable(articleId, user.getId());
        }
        articleService.readCountPlus(articleId);
        user = userService.queryHotArticle(article.getUserId());
        model.addAttribute("article", article);
        model.addAttribute("user", user);
        return "articleRead";
    }

    /**
     * @description: 删除博客，注：所有操作接口应核实用户身份（就不改了）
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
        Map<String , Object> restMap = RestMap.getRestMap();
        if(antistop == "" || antistop.length() < 1) return restMap;
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        antistop = antistop.substring(1, antistop.length()-1);
        List<Article> articleList = articleService.findUserIssue(user.getId(),antistop);
        restMap.put("data", articleList);
        return restMap;
    }

}
