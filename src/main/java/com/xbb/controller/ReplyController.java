package com.xbb.controller;

import com.xbb.pojo.Comment;
import com.xbb.pojo.Reply;
import com.xbb.pojo.User;
import com.xbb.service.CommentService;
import com.xbb.service.ReplyService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @title: ReplyController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\6 000613:22
 */
@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired private ReplyService replyService;
    @Autowired private CommentService commentService;

    /**
     * @description: 添加回复
     * @param reply
     * @param session
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/add.do")
    public Map<String, Object> add(@RequestBody Reply reply, HttpSession session) {
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        reply.setUserId(user.getId());
        reply.setReplyTime(new Date());
        replyService.add(reply);
        commentService.replyCountPlus(reply.getCommentId());

        Map<String, Object> restMap = RestMap.getRestMap();
        reply.setUser(user);
        restMap.put("data", reply);
        return restMap;
    }

    /**
     * @description: 根据评论ID查询回复列表
     * @param comment
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/query.all")
    public Map<String, Object> findReplyList(@RequestBody Comment comment){
        List<Reply> replyList = replyService.queryAll(comment.getId());
        Map<String, Object> restMap = RestMap.getRestMap();
        restMap.put("data", replyList);
        return restMap;
    }
}
