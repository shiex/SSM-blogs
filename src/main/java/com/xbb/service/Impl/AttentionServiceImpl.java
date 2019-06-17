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
    public List<User> queryFollow(int fans_id) {
        return attentionMapper.queryFollow(fans_id);
    }

    @Override
    public List<User> queryFans(int follow_id) {
        return attentionMapper.queryFans(follow_id);
    }

    @Override
    public void addFollow(Attention attention) {
        attentionMapper.addFollow(attention);
    }

    @Override
    public int findIsFollow(Integer fans_id, Integer follow_id) {
        return attentionMapper.findIsFollow(fans_id, follow_id);
    }

    @Override
    public void delectFollow(Integer fans_id, Integer follow_id) {
        attentionMapper.delectFollow(fans_id, follow_id);
    }
}
