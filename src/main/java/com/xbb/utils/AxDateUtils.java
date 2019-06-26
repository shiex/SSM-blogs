package com.xbb.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @title: ArticleDateUtils
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\4\12 001220:23
 */
public class AxDateUtils<T> {

    public static final int TIME = 1000 * 60;   //分钟
    public static final int HOUR = 60 * TIME;  //小时
    public static final int DAY = 24 * HOUR;  //天
    public static final long WEEK = 7 * DAY;  //星期
    public static final long MONTH = 4 * WEEK;  //月（28天算一个月）

    public static final String SDF_YH = "yyyy-MM-dd HH:mm:ss";
    public static final String SDF_Y = "yyyy-MM-dd";
    public static final String SDF_H = "HH:mm:ss";

    public static String yhFormat(Date date){
        return new SimpleDateFormat(SDF_YH).format(date);
    }

    public static String yFormat(Date date){
        return new SimpleDateFormat(SDF_Y).format(date);
    }

    public static String hFormat(Date date){
        return new SimpleDateFormat(SDF_H).format(date);
    }

    /**
     * @description: 计算出发布到目前的时间差
     * @param start 发布时间
     * @param end 目前时间
     * @return: java.lang.String
     */
    public static String timeInterval(long start, long end){
        long time = (end - start) / TIME;
        if(time >= 59){
            return hourInterval(start, end);
        }
        time += 1;
        return time + "分钟前";
    }

    public static String hourInterval(long start, long end){
        long hour = (end - start) / HOUR;
        if(hour >= 23){
            return dayInterval(start, end);
        }
        hour += 1;
        return hour + "小时前";
    }

    public static String dayInterval(long start, long end){
        long day = (end - start) / DAY;
        if(day >= 6){
            return weekInterval(start, end);
        }
        day += 1;
        return day + "天前";
    }

    public static String weekInterval(long start, long end){
        long week = (end - start) / WEEK;
        if(week >= 3){
            return monthInterval(start, end);
        }
        week += 1;
        return week + "星期前";
    }

    public static String monthInterval(long start, long end){
        long month = (end - start) / MONTH;
        month += 1;
        return month + "个月前";
    }

}
