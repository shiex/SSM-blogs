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

    @Autowired private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        articleMapper.add(article);
    }

    @Override
    public void update(Article article) {
        articleMapper.update(article);
    }

    @Override
    public void updateStick(Article article) {
        articleMapper.updateStick(article);
    }

    @Override
    public void removeById(int articleId) {
        articleMapper.removeById(articleId);
    }

    @Override
    public void readCountPlus(int articleId) {
        articleMapper.readCountPlus(articleId);
    }

    @Override
    public Article query(int articleId) {
        return articleMapper.query(articleId);
    }

    @Override
    public Article queryJoinTable(int articleId, int userId) {
        return articleMapper.queryJoinTable(articleId, userId);
    }

    @Override
    public List<Article> queryAll() {
        return articleMapper.queryAll();
    }

    @Override
    public List<Article> queryAllUserIssue(int userId) {
        return articleMapper.queryAllUserIssue(userId);
    }

    @Override
    public List<Article> findFullText(String antistop) {
        return articleMapper.findFullText(antistop);
    }

    @Override
    public List<Article> findUserIssue(int userId, String antistop) {
        return articleMapper.findUserIssue(userId, antistop);
    }
}
