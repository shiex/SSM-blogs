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

    void add(Article article);

    void update(Article article);

    void updateStick(Article article);

    void removeById(int articleId);

    void readCountPlus(int articleId);

    Article query(int articleId);

    Article queryJoinTable(@Param("articleId") int articleId,
                           @Param("userId") int userId);

    List<Article> queryAll();

    List<Article> queryAllUserIssue(int userId);

    List<Article> findFullText(String antistop);

    List<Article> findUserIssue(@Param("userId") int userId,
                                @Param("antistop") String antistop);

}
