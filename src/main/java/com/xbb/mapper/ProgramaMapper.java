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

    /*
        加载所有栏目
     */
    List<Programa> queryProgramaList();
}
