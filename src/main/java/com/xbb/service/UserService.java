package com.xbb.service;

import com.xbb.pojo.User;

public interface UserService {

    void add(User user);

    void update(User user);

    void FansConutPuls(int userId);

    void FansConutMinus(int userId);

    void originalCountPlus(int userId);

    void originalCountMinus(int userId);

    void updateImgFileRoot(int userId, String imgFileRoot);

    User query(int userId, String userName);

    User queryUserArticles(int userId);

    User queryHotArticle(int userId);
}
