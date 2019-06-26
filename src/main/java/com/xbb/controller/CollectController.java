package com.xbb.controller;

import com.xbb.pojo.Article;
import com.xbb.pojo.Collect;
import com.xbb.pojo.User;
import com.xbb.service.CollectService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired private CollectService collectService;

    /**
     * @description: 获取收藏列表
     * @param userId
     * @return: java.util.Map
     */
    @RequestMapping("/all.do")
    @ResponseBody
    public Map queryCollectList(@RequestBody String userId){
        Map <String, Object> map = RestMap.getRestMap();
        List<Article> articles = collectService.queryCollectList(Integer.valueOf(userId));
        for(Article article : articles){
            if(article.getTitle().length() > 40){
                article.setTitle(article.getTitle().substring(0,40) + "...");
            }
        }
        map.put("data", articles);
        return map;
    }

    /**
     * @description: 添加收藏
     * @param collect
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/add.do")
    @ResponseBody
    public Map collectAdd(@RequestBody Collect collect, HttpSession session){
        Map <String, Object> map = RestMap.getRestMap();
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        if(collect.getIsCollect() == 0){
            collectService.collectAdd(user.getId(), collect.getArticle_id());
        }else {
            collectService.collectRemove(user.getId(), collect.getArticle_id());
        }
        return map;
    }

    /**
     * @description: 删除收藏
     * @param articleId
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/remove.do")
    @ResponseBody
    public Map collectRemove(@RequestBody String articleId, HttpSession session){
        Map <String, Object> map = RestMap.getRestMap();
        User user = (User) session.getAttribute(StatusCode.SESSION_USER);
        collectService.collectRemove(user.getId(), Integer.valueOf(articleId));
        return map;
    }

}
