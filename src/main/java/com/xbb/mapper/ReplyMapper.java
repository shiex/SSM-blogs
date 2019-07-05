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

    /**
     * @description: 添加回复
     * @param reply
     * @return: void
     */
    void add(Reply reply);

    /**
     * @description: 根据评论ID查询回复列表
     * @param commentId
     * @return: java.util.List<com.xbb.pojo.Reply>
     */
    List<Reply> queryAll(int commentId);
}
