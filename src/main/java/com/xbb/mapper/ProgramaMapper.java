package com.xbb.mapper;

import com.xbb.pojo.Programa;

import java.util.List;

/**
 * @author Administrator
 * @title: ProgramaMapper
 * @projectName SSM0101
 * @description: TODO
 * @date 2019\3\9 000920:36
 */
public interface ProgramaMapper {

    /**
     * @description: 分类列表
     * @param
     * @return: java.util.List<com.xbb.pojo.Programa>
     */
    List<Programa> queryAll();

    /**
     * @description: 根据分类ID查询分类列表以及对应博客列表
     * @param programaId
     * @return: java.util.List<com.xbb.pojo.Programa>
     */
    List<Programa> queryArticles(int programaId);
}
