package com.xbb.service.Impl;

import com.xbb.mapper.AppluadMapper;
import com.xbb.pojo.Appluad;
import com.xbb.service.AppluadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void add(Appluad appluad) {
        appluadMapper.add(appluad);
    }

    @Override
    public void remove(int commentId, int userId) {
        appluadMapper.remove(commentId, userId);
    }
}
