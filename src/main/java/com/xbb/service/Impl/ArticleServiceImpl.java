package com.xbb.service.Impl;

import com.xbb.mapper.ArticleMapper;
import com.xbb.pojo.Article;
import com.xbb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: ArticleServiceImpl
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000917:23
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryArticleList(Integer programa_id) {
        return articleMapper.queryArticleList(programa_id);
    }

    @Override
    public Article queryArticleUser(Integer article_id) {
        return articleMapper.queryArticleUser(article_id);
    }

    @Override
    public void add(Article article) {
        articleMapper.add(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    @Override
    public void readCountPlus(int article_id) {
        articleMapper.readCountPlus(article_id);
    }

    @Override
    public List<Article> queryUserArticles(int userId) {
        return articleMapper.queryUserArticles(userId);
    }

    @Override
    public void updateStick(Article article) {
        articleMapper.updateStick(article);
    }

    @Override
    public void removeById(Integer articleId) {
        articleMapper.removeById(articleId);
    }

    @Override
    public Boolean queryIsOriginal(String articleId) {
        return articleMapper.queryIsOriginal(articleId);
    }

    @Override
    public Article queryByIdArticle(int id) {
        return articleMapper.queryByIdArticle(id);
    }

    @Override
    public List<Article> findArticles(String antistop) {
        return articleMapper.findArticles(antistop);
    }

    @Override
    public List<Article> findUserArticles(Integer userId, String antistop) {
        return articleMapper.findUserArticles(userId, antistop);
    }

    @Override
    public List<Article> queryHotArticle(int id) {
        return articleMapper.queryHotArticle(id);
    }

    @Override
    public List<Article> queryArticleReferral(Integer id) {
        return articleMapper.queryArticleReferral(id);
    }
}
