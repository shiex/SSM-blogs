package com.xbb.service;

import com.xbb.pojo.Article;

import java.util.List;

/**
 * @author Administrator
 * @title: CollectService
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\29 002920:34
 */
public interface CollectService {

    void add(int userId, int articleId);

    void remove(int userId, int articleId);

    List<Article> queryCollectAll(int userId);

}
