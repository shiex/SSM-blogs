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

    @Override
    public void collectAdd(Integer userId, Integer articleId) {
        collectMapper.collectAdd(userId, articleId);
    }

    @Override
    public void collectRemove(Integer userId, Integer articleId) {
        collectMapper.collectRemove(userId, articleId);
    }

    @Override
    public List<Article> queryCollectList(Integer id) {
        return collectMapper.queryCollectList(id);
    }

    @Override
    public Integer findIsCollect(Integer userId, Integer articleId) {
        return collectMapper.findIsCollect(userId,articleId);
    }
}
