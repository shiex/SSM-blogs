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

    void add(Attention attention);

    void remove(@Param("fansId") int fansId,
                @Param("followId") int followId);

    List<User> queryFollowAll(int fansId);

    List<User> queryFansAll(int followId);

}
