package com.xbb.mapper;

import com.xbb.pojo.Reply;

import java.util.List;

/**
 * @author Administrator
 * @title: ReplyMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\6 000613:26
 */
public interface ReplyMapper {

    List<Reply> findReplyList(int comment_id);

    void add(Reply reply);

}
