package com.xbb.mapper;

import com.xbb.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @title: ArticleMapper
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000919:26
 */
public interface ArticleMapper {

    /*
        根据栏目ID查询对应博客
     */
    List<Article> queryArticleList(int programa_id);

    /*
        添加博客
     */
    void add(Article article);

    /*
        修改
     */
    void updateArticle(Article article);

    /*
        根据用户ID查询用户所发布博客
     */
    List<Article> queryUserArticles (int userId);

    /*
        根据博客ID查询博客内容以及用户信息
     */
    Article queryArticleUser(Integer article_id);

    /*
        阅读数加1
     */
    void readCountPlus(int article_id);

    /*
        修改置顶状态
     */
    void updateStick(Article article);

    /*
        删除博客
     */
    void removeById(Integer articleId);

    /*
        查询是否为原创
     */
    Boolean queryIsOriginal(String articleId);

    /*
        根据博客ID查询单个博客
     */
    Article queryByIdArticle(int id);

    /*
        根据关键词在所有博客中进行查找
     */
    List<Article> findArticles(String antistop);

    /*
        根据关键词以及用户ID查询用户所发布博客
     */
    List<Article> findUserArticles(@Param("userId") Integer userId,
                                   @Param("antistop") String antistop);

    /*
        根据用户ID查询热门博客，按阅读量取前5
     */
    List<Article> queryHotArticle(int id);

    /*
        今日推荐，最低要求为阅读量200+
     */
    List<Article> queryArticleReferral(Integer id);
}
