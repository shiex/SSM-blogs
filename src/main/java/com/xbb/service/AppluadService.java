package com.xbb.service;

import com.xbb.pojo.Appluad;

import java.util.List;

/**
 * @author Administrator
 * @title: AppluadService
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\7 000715:43
 */
public interface AppluadService {

    void add(Appluad appluad);

    List<Appluad> queryAppluads(int article_id, int user_id);

    Appluad queryIsAppluad(int comment_id, int id);

    void upAppluadStatus(int comment_id,int user_id, boolean status);

}
