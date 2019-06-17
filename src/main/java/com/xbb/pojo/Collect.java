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
    public Integer user_id;
    public Integer article_id;
    public Integer isCollect; // 判断是否收藏

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }
}
