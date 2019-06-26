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

    List<Appluad> queryAppluads(@Param("article_id") int article_id,
                                @Param("user_id") int user_id);

    void add(Appluad appluad);

    Appluad queryIsAppluad(@Param("comment_id") int comment_id,
                           @Param("user_id") int user_id);

    void upAppluadStatus(@Param("comment_id")int comment_id,
                         @Param("user_id") int user_id,
                         @Param("status") boolean status);

}
