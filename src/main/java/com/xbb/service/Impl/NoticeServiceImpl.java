package com.xbb.service.Impl;

import com.xbb.mapper.NoticeMapper;
import com.xbb.pojo.Notice;
import com.xbb.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @title: NoticeServiceImpl
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\19 001921:40
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> queryNotices(int userId) {
        return noticeMapper.queryNotices(userId);
    }

    @Override
    public void noticeRemove(Integer noticeId) {
        noticeMapper.noticeRemove(noticeId);
    }

    @Override
    public void noticeSave(Notice notice) {
        noticeMapper.noticeSave(notice);
    }

    @Override
    public void noticeAdd(Notice notice) {
        noticeMapper.noticeAdd(notice);
    }

    @Override
    public Notice findByIdNotice(Integer noticeId) {
        return noticeMapper.findByIdNotice(noticeId);
    }
}
