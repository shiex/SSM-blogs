package com.xbb.service;

import com.xbb.pojo.Attention;
import com.xbb.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: AttentionService
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001723:53
 */
@Service("attentionService")
public interface AttentionService {

    void add(Attention attention);

    void remove(int fansId, int followId);

    List<User> queryFollowAll(int fansId);

    List<User> queryFansAll(int followId);

}
