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
    public void add(int userId, int articleId) {
        collectMapper.add(userId, articleId);
    }

    @Override
    public void remove(int userId, int articleId) {
        collectMapper.remove(userId, articleId);
    }

    @Override
    public List<Article> queryCollectAll(int userId) {
        return collectMapper.queryCollectAll(userId);
    }

}
