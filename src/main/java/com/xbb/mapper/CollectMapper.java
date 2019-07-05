package com.xbb.mapper;

import com.xbb.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @title: CollectMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\29 002920:35
 */
public interface CollectMapper {

    void add(@Param("userId") int userId,
             @Param("articleId") int articleId);

    void remove(@Param("userId") int userId,
                @Param("articleId") int articleId);

    List<Article> queryCollectAll(int userId);
}
