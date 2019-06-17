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
    /*
        根据用户ID以及博客ID添加收藏
     */
    void collectAdd(@Param("userId") Integer userId,
                    @Param("articleId") Integer articleId);
    /*
        根据用户ID以及博客ID取消收藏
     */
    void collectRemove(@Param("userId") Integer userId,
                       @Param("articleId") Integer articleId);

    /*
        根据用户ID查询收藏列表
     */
    List<Article> queryCollectList(Integer id);

    /*
        根据用户ID查询是否收藏了此博客
     */
    Integer findIsCollect(@Param("userId") Integer userId,
                          @Param("articleId") Integer articleId);
}
