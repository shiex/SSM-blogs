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

    /**
     * @description: 根据评论ID查询回复
     * @param reply
     * @return: void
     */
    @Override
    public void add(Reply reply) {
        replyMapper.add(reply);
    }

    /**
     * @description: 添加回复
     * @param comment_id
     * @return: java.util.List<com.xbb.pojo.Reply>
     */
    @Override
    public List<Reply> findReplyList(int comment_id) {
        return replyMapper.findReplyList(comment_id);
    }
}
