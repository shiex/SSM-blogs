package com.xbb.service.Impl;

import com.xbb.mapper.UserMapper;
import com.xbb.pojo.User;
import com.xbb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @title: UserServiceImpl
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\13 001319:30
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void FansConutPuls(int userId) {
        userMapper.FansConutPuls(userId);
    }

    @Override
    public void FansConutMinus(int userId) {
        userMapper.FansConutMinus(userId);
    }

    @Override
    public void originalCountPlus(int userId) {
        userMapper.originalCountPlus(userId);
    }

    @Override
    public void originalCountMinus(int userId) {
        userMapper.originalCountMinus(userId);
    }

    @Override
    public void updateImgFileRoot(int userId, String imgFileRoot) {
        userMapper.updateImgFileRoot(userId, imgFileRoot);
    }

    @Override
    public User query(int userId, String userName) {
        return userMapper.query(userId, userName);
    }

    @Override
    public User queryUserArticles(int userId) {
        return userMapper.queryUserArticles(userId);
    }

    @Override
    public User queryHotArticle(int userId) {
        return userMapper.queryHotArticle(userId);
    }
}
