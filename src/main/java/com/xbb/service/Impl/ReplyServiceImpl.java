package com.xbb.service.Impl;

import com.xbb.mapper.ReplyMapper;
import com.xbb.pojo.Reply;
import com.xbb.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: ReplyServiceImpl
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000917:23
 */
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public void add(Reply reply) {
        replyMapper.add(reply);
    }

    @Override
    public List<Reply> queryAll(int commentId) {
        return replyMapper.queryAll(commentId);
    }
}
