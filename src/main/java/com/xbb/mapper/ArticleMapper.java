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

    List<Article> queryArticleList(int programa_id);

    void add(Article article);

    void updateArticle(Article article);

    List<Article> queryUserArticles (int userId);

    Article queryArticleUser(Integer article_id);

    void readCountPlus(int article_id);

    void updateStick(Article article);

    void removeById(Integer articleId);

    Boolean queryIsOriginal(String articleId);

    Article queryByIdArticle(int id);

    List<Article> findArticles(String antistop);

    List<Article> findUserArticles(@Param("userId") Integer userId,
                                   @Param("antistop") String antistop);

    List<Article> queryHotArticle(int id);

    List<Article> queryArticleReferral(Integer id);
}
