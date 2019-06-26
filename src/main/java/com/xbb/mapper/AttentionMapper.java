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

    List<User> queryFollow(int fans_id);

    List<User> queryFans(int follow_id);

    void addFollow(Attention attention);

    int findIsFollow(@Param("fans_id") Integer fans_id,
                     @Param("follow_id") Integer follow_id);

    void delectFollow(@Param("fans_id") Integer fans_id,
                      @Param("follow_id") Integer follow_id);

}
