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

    void insertUser(User user);

    User findByUsername(String username);

    User queryById(int id);

    void FansConutMinus(Integer follow_id);

    void FansConutPuls(Integer follow_id);

    void updateUserData(User user);

    User queryUserArticles(int userId);

    void originalCountMinus(Integer userId);

    void originalCountPlus(Integer userId);

    String queryIsHeadPortrait(Integer id);

    String queryIsDataPhoto(Integer id);

    String queryIsThemePhoto(Integer id);

    String findByIdImgsFile(Integer id);

    void upImgsFileUrl(@Param("userId") Integer userId,
                       @Param("imgsFileUrl") String imgsFileUrl);

    void upImgPhoto(@Param("id") Integer id,
                    @Param("headPhoto") String headPhoto,
                    @Param("themePhoto") String themePhoto,
                    @Param("dataPhoto") String dataPhoto);

}
