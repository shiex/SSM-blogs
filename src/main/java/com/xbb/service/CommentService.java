package com.xbb.service;

import com.xbb.pojo.Comment;

/**
 * @author Administrator
 * @title: CommentService
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000917:22
 */
public interface CommentService {

    void add(Comment comment);

    void replyCountPlus(int articleId);

    void replyCountMinus(int articleId);

    void appluadCountPlus(int articleId);

    void appluadCountMinus(int articleId);

}
