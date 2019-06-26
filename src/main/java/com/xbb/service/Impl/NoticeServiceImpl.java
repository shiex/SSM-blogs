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

    /**
     * @description: 查询公告
     * @param userId
     * @return: java.util.List<com.xbb.pojo.Notice>
     */
    @Override
    public List<Notice> queryNotices(int userId) {
        return noticeMapper.queryNotices(userId);
    }

    /**
     * @description: 根据ID删除公告
     * @param noticeId
     * @return: void
     */
    @Override
    public void noticeRemove(Integer noticeId) {
        noticeMapper.noticeRemove(noticeId);
    }

    /**
     * @description: 编辑公告
     * @param notice
     * @return: void
     */
    @Override
    public void noticeSave(Notice notice) {
        noticeMapper.noticeSave(notice);
    }

    /**
     * @description: 添加公告
     * @param notice
     * @return: void
     */
    @Override
    public void noticeAdd(Notice notice) {
        noticeMapper.noticeAdd(notice);
    }

    /**
     * @description: 根据ID查询公告
     * @param noticeId
     * @return: com.xbb.pojo.Notice
     */
    @Override
    public Notice findByIdNotice(Integer noticeId) {
        return noticeMapper.findByIdNotice(noticeId);
    }
}
