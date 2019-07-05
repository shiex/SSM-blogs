package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.Collect;
import com.xbb.pojo.User;
import com.xbb.service.CollectService;
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
 * @title: CollectController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\29 002920:33
 */
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired private CollectService collectService;

    /**
     * @description: 收藏博客列表
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/all.do")
    public Map queryCollectList(HttpSession session){
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        List<Article> collectList = collectService.queryCollectAll(user.getId());
        Map <String, Object> restMap = RestMap.getRestMap();
        restMap.put("data", collectList);
        return restMap;
    }

    /**
     * @description: 添加/取消博客 0：添加，1：取消
     * @param collect
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/add.do")
    public Map collectAdd(@RequestBody Collect collect, HttpSession session){
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        if(collect.getIsCollect() == 0){
            collectService.add(user.getId(), collect.getArticleId());
        }else {
            collectService.remove(user.getId(), collect.getArticleId());
        }
        Map <String, Object> restMap = RestMap.getRestMap();
        return restMap;
    }

}
