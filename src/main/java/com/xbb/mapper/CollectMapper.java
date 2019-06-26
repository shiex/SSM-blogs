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

    void collectAdd(@Param("userId") Integer userId,
                    @Param("articleId") Integer articleId);

    void collectRemove(@Param("userId") Integer userId,
                       @Param("articleId") Integer articleId);

    List<Article> queryCollectList(Integer id);

    Integer findIsCollect(@Param("userId") Integer userId,
                          @Param("articleId") Integer articleId);
}
