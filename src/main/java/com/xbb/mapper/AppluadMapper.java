package com.xbb.mapper;

import com.xbb.pojo.Appluad;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @title: AppluadMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\7 000715:43
 */
public interface AppluadMapper {

    /*
        根据用户ID以及博客ID查询是否在当前博客具有点赞
     */
    List<Appluad> queryAppluads(@Param("article_id") int article_id,
                                @Param("user_id") int user_id);

    /*
        用户点赞
     */
    void add(Appluad appluad);

    /*
        根据用户ID以及评论ID查询用户是否点赞过
     */
    Appluad queryIsAppluad(@Param("comment_id") int comment_id,
                           @Param("user_id") int user_id);

    /*
        对已点赞评论的状态修改
     */
    void upAppluadStatus(@Param("comment_id")int comment_id,
                         @Param("user_id") int user_id,
                         @Param("status") boolean status);

}
