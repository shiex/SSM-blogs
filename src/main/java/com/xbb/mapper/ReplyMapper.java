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

    void add(Reply reply);

    List<Reply> queryAll(int commentId);
}
