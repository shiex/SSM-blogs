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

    List<User> queryFollow(int fans_id);

    List<User> queryFans(int follow_id);

    void addFollow(Attention attention);

    int findIsFollow(Integer fans_id, Integer follow_id);

    void delectFollow(Integer fans_id, Integer follow_id);

}
