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

    /**
     * @description: 添加收藏
     * @param userId
     * @param articleId
     * @return: void
     */
    void add(@Param("userId") int userId,
             @Param("articleId") int articleId);

    /**
     * @description: 删除收藏
     * @param userId
     * @param articleId
     * @return: void
     */
    void remove(@Param("userId") int userId,
                @Param("articleId") int articleId);

    /**
     * @description: 查询收藏列表
     * @param userId
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    List<Article> queryCollectAll(int userId);
}
