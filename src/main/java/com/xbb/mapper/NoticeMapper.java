package com.xbb.mapper;

import com.xbb.pojo.Notice;

import java.util.List;

/**
 * @author Administrator
 * @title: NoticeMapper
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\19 001921:40
 */
public interface NoticeMapper {

    List<Notice> queryNotices(int userId);

    void noticeRemove(Integer noticeId);

    void noticeSave(Notice notice);

    void noticeAdd(Notice notice);

    Notice findByIdNotice(Integer noticeId);
}
