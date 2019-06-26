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

    /**
     * @description: 以粉丝角度查询用户关注列表
     * @param fans_id
     * @return: java.util.List<com.xbb.pojo.User>
     */
    @Override
    public List<User> queryFollow(int fans_id) {
        return attentionMapper.queryFollow(fans_id);
    }

    /**
     * @description: 以关注角度查询用户粉丝列表
     * @param follow_id
     * @return: java.util.List<com.xbb.pojo.User>
     */
    @Override
    public List<User> queryFans(int follow_id) {
        return attentionMapper.queryFans(follow_id);
    }

    /**
     * @description: 添加关注，如果已关注则为删除
     * @param attention
     * @return: void
     */
    @Override
    public void addFollow(Attention attention) {
        attentionMapper.addFollow(attention);
    }

    /**
     * @description: 以粉丝角度查询是否为关注，1为已关注，0为未关注，为关注则删除
     * @param fans_id
     * @param follow_id
     * @return: int
     */
    @Override
    public int findIsFollow(Integer fans_id, Integer follow_id) {
        return attentionMapper.findIsFollow(fans_id, follow_id);
    }

    /**
     * @description: 以粉丝角度进行删除
     * @param fans_id
     * @param follow_id
     * @return: void
     */
    @Override
    public void delectFollow(Integer fans_id, Integer follow_id) {
        attentionMapper.delectFollow(fans_id, follow_id);
    }
}
