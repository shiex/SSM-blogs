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

    List<Article> queryArticleList(Integer programa_id);

    Article queryArticleUser(Integer article_id);

    void add(Article article);

    void readCountPlus(int article_id);

    List<Article> queryUserArticles(int userId);

    void updateStick(Article article);

    void removeById(Integer articleId);

    Boolean queryIsOriginal(String articleId);

    void updateArticle(Article article);

    Article queryByIdArticle(int id);

    List<Article> findArticles(String antistop);

    List<Article> findUserArticles(Integer userId, String antistop);

    List<Article> queryHotArticle(int id);

    List<Article> queryArticleReferral(Integer id);
}

