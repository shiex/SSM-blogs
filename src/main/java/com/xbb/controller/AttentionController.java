package com.xbb.controller;

import com.xbb.pojo.Attention;
import com.xbb.pojo.User;
import com.xbb.service.AttentionService;
import com.xbb.service.UserService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @title: AttentionController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001723:52
 */
@RestController
public class AttentionController {

    @Autowired private AttentionService attentionService;
    @Autowired private UserService userService;

    /**
     * @description: 前端传递关注状态，0：新增，1：删除
     * @param attention
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/follow.add")
    public Map addFollow(@RequestBody Attention attention, HttpSession session)
    {
        User u = (User) session.getAttribute(StatusCode.SESSION_USER);
        if(attention.getId() != 0){
            attention.setFansId(u.getId());
            attentionService.add(attention);
            userService.FansConutPuls(attention.getFollowId());
        }else {
            attentionService.remove(u.getId(),attention.getFollowId());
            userService.FansConutMinus(attention.getFollowId());
        }
        Map <String, Object> restMap = RestMap.getRestMap();
        return restMap;
    }

    /**
     * @description: 以粉丝角度获取所关注列表
     * @param userId
     * @return: java.util.Map
     */
    @RequestMapping("/follow.all")
    public Map queryFollow(@RequestBody int userId)
    {
        List<User> followList = attentionService.queryFollowAll(userId);
        Map<String , Object> restMap = RestMap.getRestMap();
        restMap.put("data",followList);
        return restMap;
    }

    /**
     * @description: 以被关注角度获取粉丝列表
     * @param userId
     * @return: java.util.Map
     */
    @RequestMapping("/fans.all")
    public Map queryFans(@RequestBody int userId)
    {
        List <User> fansList = attentionService.queryFansAll(userId);
        Map<String , Object> restMap = RestMap.getRestMap();
        restMap.put("data",fansList);
        return restMap;
    }

}
