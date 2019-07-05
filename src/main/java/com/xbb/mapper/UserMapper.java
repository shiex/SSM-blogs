package com.xbb.mapper;

import com.xbb.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @title: UserMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\13 001321:14
 */
public interface UserMapper {

    void add(User user);

    void update(User user);

    void FansConutPuls(int userId);

    void FansConutMinus(int userId);

    void originalCountPlus(int userId);

    void originalCountMinus(int userId);

    void updateImgFileRoot(@Param("userId") int userId,
                           @Param("imgFileRoot") String imgFileRoot);

    User query(@Param("userId") int userId,
               @Param("userName") String userName);

    User queryUserArticles(int userId);

    User queryHotArticle(int userId);
}
