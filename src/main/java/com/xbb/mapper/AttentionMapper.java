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

    /**
     * @description: 添加关注
     * @param attention
     * @return: void
     */
    void add(Attention attention);

    /**
     * @description: 根据粉丝角度删除关注
     * @param fansId
     * @param followId
     * @return: void
     */
    void remove(@Param("fansId") int fansId,
                @Param("followId") int followId);

    /**
     * @description: 查询关注列表
     * @param fansId
     * @return: java.util.List<com.xbb.pojo.User>
     */
    List<User> queryFollowAll(int fansId);

    /**
     * @description: 查询粉丝列表
     * @param followId
     * @return: java.util.List<com.xbb.pojo.User>
     */
    List<User> queryFansAll(int followId);

}
