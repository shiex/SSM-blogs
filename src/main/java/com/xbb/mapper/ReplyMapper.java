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

    /*
        根据评论ID查询回复
     */
    List<Reply> findReplyList(int comment_id);

    /*
        添加回复
     */
    void add(Reply reply);

}
