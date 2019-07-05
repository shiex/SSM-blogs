package com.xbb.service;

import com.xbb.pojo.Article;

import java.util.List;

/**
 * @author Administrator
 * @title: ArticleService
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000917:21
 */
public interface ArticleService {

    void add(Article article);

    void update(Article article);

    void updateStick(Article article);

    void removeById(int articleId);

    void readCountPlus(int articleId);

    Article queryJoinTable(int articleId, int userId);

    List<Article> queryAll();

    List<Article> queryAllUserIssue(int userId);

    List<Article> findFullText(String antistop);

    List<Article> findUserIssue(int userId, String antistop);

    Article query(int articleId);

}

