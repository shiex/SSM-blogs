package com.xbb.service;

import com.xbb.pojo.Comment;

import java.util.List;

/**
 * @author Administrator
 * @title: CommentService
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000917:22
 */
public interface CommentService {

    List<Comment> commentList(int articleId);

    void add(Comment comment);

    void replyCountPlus(int article_id);

    void replyCountMinus(int article_id);

    void appluadCountPlus(int article_id);

    void appluadCountMinus(int article_id);

}
