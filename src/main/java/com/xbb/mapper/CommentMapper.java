package com.xbb.mapper;

import com.xbb.pojo.Comment;

/**
 * @author Administrator
 * @title: CommentMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\2 000223:23
 */
public interface CommentMapper {

    /**
     * @description: 添加评论
     * @param comment
     * @return: void
     */
    void add(Comment comment);

    /**
     * @description: 回复次数加1
     * @param articleId
     * @return: void
     */
    void replyCountPlus(int articleId);

    /**
     * @description: 回复次数减1
     * @param articleId
     * @return: void
     */
    void replyCountMinus(int articleId);

    /**
     * @description: 点赞次数加1
     * @param articleId
     * @return: void
     */
    void appluadCountPlus(int articleId);

    /**
     * @description: 点赞次数减1
     * @param articleId
     * @return: void
     */
    void appluadCountMinus(int articleId);

}
