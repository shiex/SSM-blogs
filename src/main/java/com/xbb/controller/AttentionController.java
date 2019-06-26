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

    @Autowired AttentionService attentionService;
    @Autowired UserService userService;

    /**
     * @description: 点击关注，如果为已关注状态则进行删除
     * @param attention
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/follow.add")
    public Map addFollow(@RequestBody Attention attention, HttpSession session)
    {
        Map <String, Object> map = RestMap.getRestMap();
        User u = (User) session.getAttribute(StatusCode.SESSION_USER);
        int isFollow = attentionService.findIsFollow(u.getId(),attention.getFollow_id());
        // 0：未关注（新增），1：已关注（删除）
        if(isFollow == 0){
            attention.setFans_id(u.getId());
            attentionService.addFollow(attention);
            userService.FansConutPuls(attention.getFollow_id());
        }else {
            attentionService.delectFollow(u.getId(),attention.getFollow_id());
            userService.FansConutMinus(attention.getFollow_id());
        }
        return map;
    }

    /**
     * @description: 以粉丝角度获取关注列表
     * @param userId
     * @return: java.util.Map
     */
    @RequestMapping("/follow.all")
    public Map queryFollow(@RequestBody String userId)
    {
        Map<String , Object> map = RestMap.getRestMap();
        List<User> follows = attentionService.queryFollow(Integer.valueOf(userId));
        map.put("data",follows);
        return map;
    }

    /**
     * @description: 以被关注角度获取粉丝列表
     * @param userId
     * @return: java.util.Map
     */
    @RequestMapping("/fans.all")
    public Map queryFans(@RequestBody String userId)
    {
        Map<String , Object> map = RestMap.getRestMap();
        List <User> fanss = attentionService.queryFans(Integer.valueOf(userId));
        map.put("data",fanss);
        return map;
    }

}
