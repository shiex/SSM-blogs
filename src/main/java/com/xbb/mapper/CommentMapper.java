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

    void add(Comment comment);

    void replyCountPlus(int articleId);

    void replyCountMinus(int articleId);

    void appluadCountPlus(int articleId);

    void appluadCountMinus(int articleId);

}
