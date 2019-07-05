package com.xbb.mapper;

import com.xbb.pojo.Appluad;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @title: AppluadMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\7 000715:43
 */
public interface AppluadMapper {

    /**
     * @description: 添加点赞
     * @param appluad
     * @return: void
     */
    void add(Appluad appluad);

    /**
     * @description: 根据评论ID用户ID删除点赞
     * @param commentId
     * @param userId
     * @return: void
     */
    void remove(@Param("commentId") int commentId,
                @Param("userId") int userId);

}
