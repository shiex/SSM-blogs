package com.xbb.utils;

import com.xbb.pojo.Article;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @title: ArticleDateUtils
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\12 001220:23
 */
public class ArticleDateUtils {

    // 计算博客发布时间到目前的天数
    // 如果未满天则按小时计算
    public static void setDayTime(List<Article> articles){
        long showTime = new Date().getTime();
        for(Article article : articles)
        {
            long issue_time = article.getIssue_time().getTime();
            long pastTime = showTime - issue_time;
            int day = (int) pastTime / (1000 * 60 * 60 * 24); // 以天计算
            if(day == 0){
                int hour = (int) pastTime / (1000 * 60 * 60); // 按小时计算
                if(hour == 0){
                    int minute = (int) pastTime / (1000 * 60); // 按分钟计算
                    if(minute == 0) minute = 1;
                    article.setPastTime(minute + "分钟前");
                }else {
                    article.setPastTime(hour + "小时前");
                }

            }else if(day >= 31){    // 天数大于等于31按月份计算
                int month = (int) pastTime / (1000 * 60 * 60 * 24 * 30);
                article.setPastTime(month + "个月前");
            }else {         // 按天计算
                article.setPastTime(day + "天前");
            }
        }
    }
}
