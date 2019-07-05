package com.xbb.controller;

import com.xbb.pojo.Appluad;
import com.xbb.pojo.User;
import com.xbb.service.AppluadService;
import com.xbb.service.CommentService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Administrator
 * @title: AppluadController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\7 000715:42
 */
@RestController
public class AppluadController {

    @Autowired private AppluadService appluadService;
    @Autowired private CommentService commentService;

    /**
     * @description: id=0为点赞，反之取消点赞
     * @param appluad
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("appluad.add")
    public Map add(@RequestBody Appluad appluad, HttpSession session){
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        if(appluad.getId() == 0){
            appluad.setUserId(user.getId());
            appluad.setStatus(true);
            appluadService.add(appluad);
            commentService.appluadCountPlus(appluad.getCommentId());
        }else{
            appluadService.remove(appluad.getCommentId(), user.getId());
            commentService.appluadCountMinus(appluad.getCommentId());
        }

        Map<String , Object> restMap = RestMap.getRestMap();
        return restMap;
    }

}
