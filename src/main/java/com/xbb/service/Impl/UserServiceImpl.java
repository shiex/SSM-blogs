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

    /**
     * @description: 根据用户名查询用户是否存在
     * @param username
     * @return: com.xbb.pojo.User
     */
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * @description: 删除用户
     * @param id
     * @return: com.xbb.pojo.User
     */
    @Override
    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    /**
     * @description: 添加用户
     * @param user
     * @return: void
     */
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    /**
     * @description: 修改用户信息
     * @param user
     * @return: void
     */
    @Override
    public void updateUserData(User user) {
        userMapper.updateUserData(user);
    }

    /**
     * @description: 1对多查询用户以及全部博客
     * @param userId
     * @return: com.xbb.pojo.User
     */
    @Override
    public User queryUserArticles(int userId) {
        return userMapper.queryUserArticles(userId);
    }

    /**
     * @description: 粉丝数量减1
     * @param follow_id
     * @return: void
     */
    @Override
    public void FansConutPuls(Integer follow_id) {
        userMapper.FansConutPuls(follow_id);
    }

    /**
     * @description: 粉丝数量加1
     * @param follow_id
     * @return: void
     */
    @Override
    public void FansConutMinus(Integer follow_id) {
        userMapper.FansConutMinus(follow_id);
    }

    /**
     * @description: 原创数量加1
     * @param userId
     * @return: void
     */
    @Override
    public void originalCountPlus(Integer userId) {
        userMapper.originalCountPlus(userId);
    }

    /**
     * @description: 原创数量减1
     * @param userId
     * @return: void
     */
    @Override
    public void originalCountMinus(Integer userId) {
        userMapper.originalCountMinus(userId);
    }

    /**
     * @description: 查询是否存在头像，存在则需删除
     * @param id
     * @return: java.lang.String
     */
    @Override
    public String queryIsHeadPortrait(Integer id) {
        return userMapper.queryIsHeadPortrait(id);
    }

    /**
     * @description: 查询图片存储父目录
     * @param id
     * @return: java.lang.String
     */
    @Override
    public String findByIdImgsFile(Integer id) {
        return userMapper.findByIdImgsFile(id);
    }

    /**
     * @description: 插入图片存储父目录路径
     * @param userId
     * @param imgsFileUrl
     * @return: void
     */
    @Override
    public void upImgsFileUrl(Integer userId, String imgsFileUrl) {
        userMapper.upImgsFileUrl(userId, imgsFileUrl);
    }

    /**
     * @description: 动态修改图片路径
     * @param id
     * @param headPhoto
     * @param themePhoto
     * @param dataPhoto
     * @return: void
     */
    @Override
    public void upImgPhoto(Integer id, String headPhoto, String themePhoto, String dataPhoto) {
        userMapper.upImgPhoto(id, headPhoto, themePhoto, dataPhoto);
    }

    /**
     * @description: 查询是否存在资料背景图，存在则需删除
     * @param id
     * @return: java.lang.String
     */
    @Override
    public String queryIsThemePhoto(Integer id) {
        return userMapper.queryIsThemePhoto(id);
    }

    /**
     * @description: 在主页背景图，存在则需删除
     * @param id
     * @return: java.lang.String
     */
    @Override
    public String queryIsDataPhoto(Integer id) {
        return userMapper.queryIsDataPhoto(id);
    }
}
