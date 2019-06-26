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

    /**
     * @description: 查询点赞列表
     * @param article_id
     * @param user_id
     * @return: java.util.List<com.xbb.pojo.Appluad>
     */
    @Override
    public List<Appluad> queryAppluads(int article_id, int user_id) {
        return appluadMapper.queryAppluads(article_id, user_id);
    }

    /**
     * @description: 添加点赞
     * @param appluad
     * @return: void
     */
    @Override
    public void add(Appluad appluad) {
        appluadMapper.add(appluad);
    }

    /**
     * @description: 查询是否存在点赞行为
     * @param comment_id
     * @param user_id
     * @return: com.xbb.pojo.Appluad
     */
    @Override
    public Appluad queryIsAppluad(int comment_id, int user_id) {
        return appluadMapper.queryIsAppluad(comment_id, user_id);
    }

    /**
     * @description: 修改点赞状态
     * @param comment_id
     * @param user_id
     * @param status
     * @return: void
     */
    @Override
    public void upAppluadStatus(int comment_id,int user_id, boolean status) {
        appluadMapper.upAppluadStatus(comment_id,user_id,status);
    }
}
