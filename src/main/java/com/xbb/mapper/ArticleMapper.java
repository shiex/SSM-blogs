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

    /**
     * @description:  添加博客
     * @param article
     * @return: void
     */
    void add(Article article);

    /**
     * @description:  修改博客
     * @param article
     * @return: void
     */
    void update(Article article);

    /**
     * @description:  修改博客置顶状态
     * @param article
     * @return: void
     */
    void updateStick(Article article);

    /**
     * @description:  删除博客
     * @param articleId
     * @return: void
     */
    void removeById(int articleId);

    /**
     * @description:  阅读量加1
     * @param articleId
     * @return: void
     */
    void readCountPlus(int articleId);

    /**
     * @description: 查询单个博客
     * @param articleId
     * @return: com.xbb.pojo.Article
     */
    Article query(int articleId);

    /**
     * @description: 查询博客以及评论和用户是否对此评论存在点赞行为
     * @param articleId
     * @param userId
     * @return: com.xbb.pojo.Article
     */
    Article queryJoinTable(@Param("articleId") int articleId,
                           @Param("userId") int userId);

    /**
     * @description: 博客列表
     * @param
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    List<Article> queryAll();

    /**
     * @description: 查询用户发布博客
     * @param userId
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    List<Article> queryAllUserIssue(int userId);

    /**
     * @description: 按关键词全文查询博客
     * @param antistop
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    List<Article> findFullText(String antistop);

    /**
     * @description: 按关键词在用户博客管理中查询博客
     * @param userId
     * @param antistop
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    List<Article> findUserIssue(@Param("userId") int userId,
                                @Param("antistop") String antistop);

}
