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

    /*
        注册用户插入
     */
    void insertUser(User user);

    /*
        根据用户名查询用户是否存在
     */
    User findByUsername(String username);

    /*
        根据ID查询用户
     */
    User queryById(int id);

    /*
        粉丝数量加1
     */
    void FansConutMinus(Integer follow_id);

    /*
        粉丝数量减1
     */
    void FansConutPuls(Integer follow_id);

    void updateUserData(User user);

    /*
        1对多查询用户以及全部博客
     */
    User queryUserArticles(int userId);

    /*
        原创数量减1
     */
    void originalCountMinus(Integer userId);

    /*
        原创数量加1
     */
    void originalCountPlus(Integer userId);

    /*
        查询是否存在头像，存在则需删除
     */
    String queryIsHeadPortrait(Integer id);

    /*
        查询是否存在主页背景图，存在则需删除
     */
    String queryIsDataPhoto(Integer id);

    /*
        查询是否存在资料背景图，存在则需删除
     */
    String queryIsThemePhoto(Integer id);

    /*
        查询图片存储父目录
     */
    String findByIdImgsFile(Integer id);

    /*
        插入图片存储父目录路径
     */
    void upImgsFileUrl(@Param("userId") Integer userId,
                       @Param("imgsFileUrl") String imgsFileUrl);

    /*
        动态修改图片路径
     */
    void upImgPhoto(@Param("id") Integer id,
                    @Param("headPhoto") String headPhoto,
                    @Param("themePhoto") String themePhoto,
                    @Param("dataPhoto") String dataPhoto);

}
