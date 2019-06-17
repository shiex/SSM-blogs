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

    /*
        查询公告
     */
    List<Notice> queryNotices(int userId);

    /*
        根据ID删除公告
     */
    void noticeRemove(Integer noticeId);

    /*
        编辑公告
     */
    void noticeSave(Notice notice);

    /*
        添加公告
     */
    void noticeAdd(Notice notice);

    /*
        根据ID查询公告
     */
    Notice findByIdNotice(Integer noticeId);
}
