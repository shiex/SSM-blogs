package com.xbb.mapper;

import com.xbb.pojo.Comment;

import java.util.List;

/**
 * @author Administrator
 * @title: CommentMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\2 000223:23
 */
public interface CommentMapper {

    List<Comment> commentList(int articleId);

    void add(Comment comment);

    void replyCountPlus(int article_id);

    void replyCountMinus(int article_id);

    void appluadCountMinus(int article_id);

    void appluadCountPlus(int article_id);
}
