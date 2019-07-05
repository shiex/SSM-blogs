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

    /**
     * @description: 添加用户
     * @param user
     * @return: void
     */
    void add(User user);

    /**
     * @description: 修改用户
     * @param user
     * @return: void
     */
    void update(User user);

    /**
     * @description: 粉丝数量加1
     * @param userId
     * @return: void
     */
    void FansConutPuls(int userId);
    /**
     * @description: 粉丝数量减1
     * @param userId
     * @return: void
     */
    void FansConutMinus(int userId);

    /**
     * @description: 原创数量加1
     * @param userId
     * @return: void
     */
    void originalCountPlus(int userId);

    /**
     * @description: 原创数量减1
     * @param userId
     * @return: void
     */
    void originalCountMinus(int userId);

    /**
     * @description: 查询用户存储图片父目录
     * @param userId
     * @param imgFileRoot
     * @return: void
     */
    void updateImgFileRoot(@Param("userId") int userId,
                           @Param("imgFileRoot") String imgFileRoot);

    /**
     * @description: 根据ID或者用户名查询用户
     * @param userId
     * @param userName
     * @return: com.xbb.pojo.User
     */
    User query(@Param("userId") int userId,
               @Param("userName") String userName);

    /**
     * @description: 查询用户信息以及博客列表
     * @param userId
     * @return: com.xbb.pojo.User
     */
    User queryUserArticles(int userId);

    /**
     * @description: 查询用户信息以及热门博客
     * @param userId
     * @return: com.xbb.pojo.User
     */
    User queryHotArticle(int userId);
}
