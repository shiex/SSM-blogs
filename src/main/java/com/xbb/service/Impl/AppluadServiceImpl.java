package com.xbb.service.Impl;

import com.xbb.mapper.AppluadMapper;
import com.xbb.pojo.Appluad;
import com.xbb.service.AppluadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: AppluadServiceImpl
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\7 000715:44
 */
@Service("appluadService")
public class AppluadServiceImpl implements AppluadService {

    @Autowired
    AppluadMapper appluadMapper;

    @Override
    public List<Appluad> queryAppluads(int article_id, int user_id) {
        return appluadMapper.queryAppluads(article_id, user_id);
    }

    @Override
    public void add(Appluad appluad) {
        appluadMapper.add(appluad);
    }

    @Override
    public Appluad queryIsAppluad(int comment_id, int user_id) {
        return appluadMapper.queryIsAppluad(comment_id, user_id);
    }

    @Override
    public void upAppluadStatus(int comment_id,int user_id, boolean status) {
        appluadMapper.upAppluadStatus(comment_id,user_id,status);
    }
}
