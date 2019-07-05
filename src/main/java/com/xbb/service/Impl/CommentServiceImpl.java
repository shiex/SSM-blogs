package com.xbb.service.Impl;

import com.xbb.mapper.CommentMapper;
import com.xbb.pojo.Comment;
import com.xbb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void add(Comment comment) {
        commentMapper.add(comment);
    }

    @Override
    public void replyCountPlus(int articleId) {
        commentMapper.replyCountPlus(articleId);
    }

    @Override
    public void replyCountMinus(int articleId) {
        commentMapper.replyCountMinus(articleId);
    }

    @Override
    public void appluadCountMinus(int articleId) {
        commentMapper.appluadCountMinus(articleId);
    }


    @Override
    public void appluadCountPlus(int articleId) {
        commentMapper.appluadCountPlus(articleId);
    }
}
