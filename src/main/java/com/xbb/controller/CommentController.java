package com.xbb.controller;

import com.xbb.pojo.Comment;
import com.xbb.pojo.User;
import com.xbb.service.CommentService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class CommentController {

    @Autowired private CommentService commentService;

    /**
     * @description: 添加评论
     * @param comment
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/comment.add")
    public Map add(@RequestBody Comment comment, HttpSession session) {
        // 插入数据库
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        comment.setUserId(user.getId());
        comment.setCommentTime(new Date());
        commentService.add(comment);

        Map<String , Object> restMap = RestMap.getRestMap();
        comment.setUser(user);
        restMap.put("data", comment);
        return restMap;
    }

}
