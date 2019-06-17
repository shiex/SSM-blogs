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
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUserData(User user) {
        userMapper.updateUserData(user);
    }

    @Override
    public User queryUserArticles(int userId) {
        return userMapper.queryUserArticles(userId);
    }

    @Override
    public void FansConutPuls(Integer follow_id) {
        userMapper.FansConutPuls(follow_id);
    }

    @Override
    public void FansConutMinus(Integer follow_id) {
        userMapper.FansConutMinus(follow_id);
    }

    @Override
    public void originalCountPlus(Integer userId) {
        userMapper.originalCountPlus(userId);
    }

    @Override
    public void originalCountMinus(Integer userId) {
        userMapper.originalCountMinus(userId);
    }

    @Override
    public String queryIsHeadPortrait(Integer id) {
        return userMapper.queryIsHeadPortrait(id);
    }

    @Override
    public String findByIdImgsFile(Integer id) {
        return userMapper.findByIdImgsFile(id);
    }

    @Override
    public void upImgsFileUrl(Integer userId, String imgsFileUrl) {
        userMapper.upImgsFileUrl(userId, imgsFileUrl);
    }

    @Override
    public void upImgPhoto(Integer id, String headPhoto, String themePhoto, String dataPhoto) {
        userMapper.upImgPhoto(id, headPhoto, themePhoto, dataPhoto);
    }

    @Override
    public String queryIsThemePhoto(Integer id) {
        return userMapper.queryIsThemePhoto(id);
    }

    @Override
    public String queryIsDataPhoto(Integer id) {
        return userMapper.queryIsDataPhoto(id);
    }
}
