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

    /**
     * @description: 查询博客列表
     * @param programa_id
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    @Override
    public List<Article> queryArticleList(Integer programa_id) {
        return articleMapper.queryArticleList(programa_id);
    }

    /**
     * @description: 查询单个博客
     * @param article_id
     * @return: com.xbb.pojo.Article
     */
    @Override
    public Article queryArticleUser(Integer article_id) {
        return articleMapper.queryArticleUser(article_id);
    }

    /**
     * @description: 添加博客
     * @param article
     * @return: void
     */
    @Override
    public void add(Article article) {
        articleMapper.add(article);
    }

    /**
     * @description: 修改博客
     * @param article
     * @return: void
     */
    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    /**
     * @description: 阅读数量递增
     * @param article_id
     * @return: void
     */
    @Override
    public void readCountPlus(int article_id) {
        articleMapper.readCountPlus(article_id);
    }

    /**
     * @description: 查询用户发布博客列表
     * @param userId
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    @Override
    public List<Article> queryUserArticles(int userId) {
        return articleMapper.queryUserArticles(userId);
    }

    /**
     * @description: 修改置顶状态
     * @param article
     * @return: void
     */
    @Override
    public void updateStick(Article article) {
        articleMapper.updateStick(article);
    }

    /**
     * @description: 删除博客
     * @param articleId
     * @return: void
     */
    @Override
    public void removeById(Integer articleId) {
        articleMapper.removeById(articleId);
    }

    /**
     * @description: 查询是否为原创【true：是，false：不是】
     * @param articleId
     * @return: java.lang.Boolean
     */
    @Override
    public Boolean queryIsOriginal(String articleId) {
        return articleMapper.queryIsOriginal(articleId);
    }

    /**
     * @description: 查询单个博客
     * @param id
     * @return: com.xbb.pojo.Article
     */
    @Override
    public Article queryByIdArticle(int id) {
        return articleMapper.queryByIdArticle(id);
    }

    /**
     * @description: 根据关键词在所有博客中进行查找
     * @param antistop
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    @Override
    public List<Article> findArticles(String antistop) {
        return articleMapper.findArticles(antistop);
    }

    /**
     * @description: 根据关键词以及用户ID查询用户所发布博客
     * @param userId
     * @param antistop
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    @Override
    public List<Article> findUserArticles(Integer userId, String antistop) {
        return articleMapper.findUserArticles(userId, antistop);
    }

    /**
     * @description: 根据用户ID查询热门博客，按阅读量取前5
     * @param id
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    @Override
    public List<Article> queryHotArticle(int id) {
        return articleMapper.queryHotArticle(id);
    }

    /**
     * @description: 今日推荐，最低要求为阅读量200+
     * @param id
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    @Override
    public List<Article> queryArticleReferral(Integer id) {
        return articleMapper.queryArticleReferral(id);
    }
}
