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

    /*
        根据博客ID查询评论
     */
    List<Comment> commentList(int articleId);

    /*
        添加评论
     */
    void add(Comment comment);

    /*
        回复数量递增
     */
    void replyCountPlus(int article_id);

    /*
        回复数量递减
     */
    void replyCountMinus(int article_id);

    /*
        点赞数递增
     */
    void appluadCountMinus(int article_id);

    /*
        点赞数递减
     */
    void appluadCountPlus(int article_id);
}
