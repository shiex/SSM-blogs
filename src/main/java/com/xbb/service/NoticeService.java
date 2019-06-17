package com.xbb.service;

import com.xbb.pojo.Notice;

import java.util.List;

/**
 * @author Administrator
 * @title: NoticeService
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\19 001921:40
 */
public interface NoticeService {

    List<Notice> queryNotices(int userId);

    void noticeRemove(Integer noticeId);

    void noticeSave(Notice notice);

    void noticeAdd(Notice notice);

    Notice findByIdNotice(Integer noticeId);
}
