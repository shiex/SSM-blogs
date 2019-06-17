package com.xbb.controller;

import com.xbb.pojo.Comment;
import com.xbb.pojo.User;
import com.xbb.service.CommentService;
import com.xbb.utils.RestMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @author Administrator
 * @title: CommentController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001723:52
 */
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/comment.add")
    @ResponseBody
    public Map add(@RequestBody Comment comment, HttpSession session) {

        // 插入数据库
        User user = (User) session.getAttribute("SESSION_USER");
        comment.setUser_id(user.getId());
        comment.setUsername(user.getUsername());
        comment.setComment_time(new Date());
        commentService.add(comment);

        Map<String , Object> map = RestMap.getRestMap();
        return map;
    }
    //  添加评论重新生成静态页面
    /*@RequestMapping("/comment.add")
    @ResponseBody
    public Map add(@RequestBody Comment comment, HttpSession session)
    {
        User user = (User) session.getAttribute("SESSION_USER");

        // 插入数据库
        comment.setUser_id(user.getId());
        comment.setUsername(user.getUsername());
        comment.setComment_time(new Date());
        commentService.add(comment);

        // 生成静态页面
        int article_id = comment.getArticle_id();
        List<Comment> list_comment = commentService.commentList(article_id);
        Article article = articleService.queryById(article_id);
        Map<String, Object> model = RestMap.getRestMap(); // 数据源
        model.put("ctxPath", StatusCode.CONTEXT_PATH);
        model.put("article", article);
        model.put("list_comment", list_comment);
        String template = StatusCode.TEMPLATE_ROOT + "article_read.ftl";    // 模板路径
        String htmlPath = "/" + article.getRead_url(); // 对已存在的静态页面进行修改，添加评论内容
        try{
            GenerateHtml.i.GenHtml(template , model, htmlPath);
        }catch (Exception e){
            e.printStackTrace();
        }

        model = RestMap.getRestMap();
        model.put("data",article.getRead_url());

        return model;
    }*/
}
