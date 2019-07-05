package com.xbb.service.Impl;

import com.xbb.mapper.AttentionMapper;
import com.xbb.pojo.Attention;
import com.xbb.pojo.User;
import com.xbb.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: AttentionServiceImpl
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001723:53
 */
@Service("attentionService")
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private AttentionMapper attentionMapper;

    @Override
    public void add(Attention attention) {
        attentionMapper.add(attention);
    }

    @Override
    public void remove(int fansId, int followId) {
        attentionMapper.remove(fansId, followId);
    }

    @Override
    public List<User> queryFollowAll(int fansId) {
        return attentionMapper.queryFollowAll(fansId);
    }

    @Override
    public List<User> queryFansAll(int followId) {
        return attentionMapper.queryFansAll(followId);
    }
}
