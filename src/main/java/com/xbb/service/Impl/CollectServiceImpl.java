package com.xbb.service.Impl;

import com.xbb.mapper.CollectMapper;
import com.xbb.pojo.Article;
import com.xbb.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: CollectServiceImpl
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\29 002920:34
 */
@Service("collectService")
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    /**
     * @description: 根据用户ID以及博客ID添加收藏
     * @param userId
     * @param articleId
     * @return: void
     */
    @Override
    public void collectAdd(Integer userId, Integer articleId) {
        collectMapper.collectAdd(userId, articleId);
    }

    /**
     * @description: 根据用户ID以及博客ID取消收藏
     * @param userId
     * @param articleId
     * @return: void
     */
    @Override
    public void collectRemove(Integer userId, Integer articleId) {
        collectMapper.collectRemove(userId, articleId);
    }

    /**
     * @description: 根据用户ID查询收藏列表
     * @param id
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    @Override
    public List<Article> queryCollectList(Integer id) {
        return collectMapper.queryCollectList(id);
    }

    /**
     * @description: 根据用户ID查询是否收藏了此博客
     * @param userId
     * @param articleId
     * @return: java.lang.Integer
     */
    @Override
    public Integer findIsCollect(Integer userId, Integer articleId) {
        return collectMapper.findIsCollect(userId,articleId);
    }
}
