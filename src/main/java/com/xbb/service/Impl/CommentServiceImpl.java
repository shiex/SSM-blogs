package com.xbb.service.Impl;

import com.xbb.mapper.CommentMapper;
import com.xbb.pojo.Comment;
import com.xbb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: CommentServiceImpl
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000917:23
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    /**
     * @description: 根据博客ID查询评论
     * @param articleId
     * @return: java.util.List<com.xbb.pojo.Comment>
     */
    @Override
    public List<Comment> commentList(int articleId) {
        return commentMapper.commentList(articleId);
    }

    /**
     * @description: 添加评论
     * @param comment
     * @return: void
     */
    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }

    /**
     * @description: 回复数量递增
     * @param article_id
     * @return: void
     */
    @Override
    public void replyCountPlus(int article_id) {
        commentMapper.replyCountPlus(article_id);
    }

    /**
     * @description: 回复数量递减
     * @param article_id
     * @return: void
     */
    @Override
    public void replyCountMinus(int article_id) {
        commentMapper.replyCountMinus(article_id);
    }

    /**
     * @description: 点赞数递增
     * @param article_id
     * @return: void
     */
    @Override
    public void appluadCountMinus(int article_id) {
        commentMapper.appluadCountMinus(article_id);
    }

    /**
     * @description: 点赞数递减
     * @param article_id
     * @return: void
     */
    @Override
    public void appluadCountPlus(int article_id) {
        commentMapper.appluadCountPlus(article_id);
    }
}
