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

    void add(Appluad appluad);

    void remove(@Param("commentId") int commentId,
                @Param("userId") int userId);

}
