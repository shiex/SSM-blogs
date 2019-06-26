package com.xbb.controller;

import com.xbb.pojo.Comment;
import com.xbb.pojo.Reply;
import com.xbb.pojo.User;
import com.xbb.service.CommentService;
import com.xbb.service.ReplyService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;
    @Autowired
    CommentService commentService;

    // 添加回复
    @RequestMapping("/reply.add")
    @ResponseBody
    public Map<String, Object> add(@RequestBody Reply reply, HttpSession session) {
        Map<String, Object> restMap = RestMap.getRestMap();
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        reply.setUser_id(user.getId());
        reply.setReply_time(new Date());
        replyService.add(reply);

        commentService.replyCountPlus(reply.getComment_id());
        return restMap;
    }

    /*
        根据评论ID查询挂靠回复
        问题：ajax请求返回406（原因：后缀为.list）
        解决：将后缀改写
     */
    @RequestMapping("/reply.find")
    @ResponseBody
    public Map<String, Object> findReplyList(@RequestBody Comment comment){
        Map<String, Object> restMap = RestMap.getRestMap();
        List<Reply> list_relply = replyService.findReplyList(comment.getId());
        restMap.put("data", list_relply);
        return restMap;
    }
}
