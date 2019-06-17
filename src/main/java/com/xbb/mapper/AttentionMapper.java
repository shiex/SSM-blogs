package com.xbb.mapper;

import com.xbb.pojo.Attention;
import com.xbb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @title: AttentionMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001723:53
 */
public interface AttentionMapper {

    /*
        以粉丝角度查询用户关注列表
     */
    List<User> queryFollow(int fans_id);

    /*
        以关注角度查询用户粉丝列表
     */
    List<User> queryFans(int follow_id);

    /*
        添加关注，如果已关注则为删除
     */
    void addFollow(Attention attention);

    /*
        以粉丝角度查询是否为关注，1为已关注，0为未关注，为关注则删除
     */
    int findIsFollow(@Param("fans_id") Integer fans_id,
                     @Param("follow_id") Integer follow_id);

    /*
        以粉丝角度进行删除
     */
    void delectFollow(@Param("fans_id") Integer fans_id,
                      @Param("follow_id") Integer follow_id);

}
