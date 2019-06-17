package com.xbb.service;

import com.xbb.pojo.User;

public interface UserService {

    User findByUsername(String username);

    void insertUser(User user);

    void updateUserData(User user);

    User queryById(int userId);

    void FansConutPuls(Integer follow_id);

    void FansConutMinus(Integer follow_id);

    User queryUserArticles(int userId);

    void originalCountPlus(Integer userId);

    void originalCountMinus(Integer userId);

    void upImgsFileUrl(Integer userId, String imgsFileUrl);

    void upImgPhoto(Integer id, String headPhoto, String themePhoto, String dataPhoto);

    String findByIdImgsFile(Integer id);

    String queryIsHeadPortrait(Integer id);

    String queryIsThemePhoto(Integer id);

    String queryIsDataPhoto(Integer id);

}
