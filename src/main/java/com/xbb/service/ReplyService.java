package com.xbb.service;

import com.xbb.pojo.Reply;

import java.util.List;

/**
 * @author Administrator
 * @title: ReplyService
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000917:22
 */
public interface ReplyService {

    void add(Reply reply);

    List<Reply> queryAll(int commentId);
}
