package com.xbb.controller;

import com.xbb.pojo.Notice;
import com.xbb.pojo.User;
import com.xbb.service.NoticeService;
import com.xbb.utils.RestMap;
import com.xbb.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @title: NoticeController
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\19 001921:38
 */

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * @description: 初始化加载公告
     * @param noticeId
     * @return: java.util.Map
     */
    @RequestMapping("/notice/list.all")
    public Map loadNotice(@RequestBody String noticeId){
        Map<String , Object> map = RestMap.getRestMap();
        List<Notice> notices = noticeService.queryNotices(Integer.valueOf(noticeId));
        map.put("data", notices);
        return map;
    }

    /**
     * @description: 添加与编辑公告
     * @param notice
     * @param session
     * @return: java.util.Map
     */
    @RequestMapping("/notice/save.do")
    public Map noticeSave(@RequestBody Notice notice, HttpSession session){
        Map<String , Object> map = RestMap.getRestMap();
        // id：0为添加，反之为编辑
        if(notice.getId() == 0){
            User user = (User) session.getAttribute(StatusCode.SESSION_USER);
            notice.setUser_id(user.getId());
            noticeService.noticeAdd(notice);
        }else {
            noticeService.noticeSave(notice);
        }
        return map;
    }

    /**
     * @description: 删除公告
     * @param noticeId
     * @return: java.util.Map
     */
    @RequestMapping("/notice/remove.do")
    public Map noticeRemove(@RequestBody String  noticeId){
        Map<String , Object> map = RestMap.getRestMap();
        noticeService.noticeRemove(Integer.valueOf(noticeId));
        return map;
    }

    /**
     * @description: 查看公告
     * @param noticeId
     * @return: java.util.Map
     */
    @RequestMapping("/notice/read.do")
    public Map readNotice(@RequestBody String noticeId){
        Map<String , Object> map = RestMap.getRestMap();
        Notice notice = noticeService.findByIdNotice(Integer.valueOf(noticeId));
        map.put("data", notice);
        return map;
    }
}
