package com.xbb.utils;

import com.xbb.pojo.Article;
import com.xbb.pojo.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author shiex-薛
 * @title: ArticleUtlis
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\6\26 002622:07
 */
public class BlogsUtlis {

    public static Random random = new Random();

    /**
     * @description: 标题控制在22字数内
     * @param articles
     * @return: void
     */
    public static void setTitle(List<Article> articles){
        if(articles != null && articles.size() > 0){
            for(Article article : articles){
                if(article.getTitle().length() > 15){
                    int n = random.nextInt(15) + 7;
                    String title = article.getTitle().substring(0,n);
                    article.setTitle(title);
                }
            }
        }
    }

    public static void setTitleShow(Article article){
        String title = article.getTitle();
        int n = random.nextInt(30) + 50;
        if(n < title.length()){
            article.setTitleShow(title.substring(0, n));
        }
        article.setTitleShow(title);
    }

    /**
     * @description: 计算出发布博客到目前的时差
     * @param articles
     * @return: boolean
     */
    public static boolean setDate(List<Article> articles){
        if(articles != null && articles.size() > 0){
            long end = new Date().getTime();
            for(Article article : articles){
                String timeLog = AxDateUtils.timeInterval(article.getIssueTime().getTime(), end);
                article.setPastTime(timeLog);
            }
            return true;
        }
        return false;
    }

    /**
     * @description: MD5算法加密
     * @param user
     * @return: java.lang.String
     */
    public static String pswdMd5(User user, int number){
        Object usernameSalt = ByteSource.Util.bytes(user.getUsername());
        Object result = new SimpleHash(StatusCode.MD5, user.getPassword(), usernameSalt, number);
        return result.toString();
    }

    public static String pswdMD5(User user){
        return pswdMd5(user, 1024);
    }

    /**
     * @description: 按阅读量排序，返回size大小的List
     * @param articles
     * @param size
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    public static List<Article> extractHot(List<Article> articles, int size){
        List<Article> articleList = AxCopyUtils.shallowCopy(articles);
        Collections.sort(articleList, new ArticleSort());
        if(size > articleList.size()) return articleList;
        return articleList.subList(0, size);
    }

    /**
     * @description: 在 0-range 区间返回size大小的List
     * @param articles
     * @param range
     * @param size
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    public static List<Article> extractHot(List<Article> articles,int range, int size){
        return extractHot(articles.subList(0, range), size);
    }

    /**
     * @description: 在 fromIndex-toIndex 区间返回size大小的List
     * @param articles
     * @param fromIndex
     * @param toIndex
     * @param size
     * @return: java.util.List<com.xbb.pojo.Article>
     */
    public static List<Article> extractHot(List<Article> articles,int fromIndex,int toIndex, int size){
        return extractHot(articles.subList(fromIndex, toIndex), size);
    }
}
