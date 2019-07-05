package com.xbb.service;

import com.xbb.pojo.Appluad;

/**
 * @author Administrator
 * @title: AppluadService
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\7 000715:43
 */
public interface AppluadService {

    void add(Appluad appluad);

    void remove(int commentId, int userId);

}
