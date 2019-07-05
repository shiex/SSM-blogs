package com.xbb.pojo;

/**
 * @author Administrator
 * @title: Collect
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\29 002920:01
 */
public class Collect {

    public Integer id;
    public Integer userId;
    public Integer articleId;
    public Integer isCollect; // 判断是否收藏

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
