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

    void collectAdd(Integer id, Integer article_id);

    void collectRemove(Integer id, Integer article_id);

    List<Article> queryCollectList(Integer id);

    Integer findIsCollect(Integer userId, Integer articleId);
}
