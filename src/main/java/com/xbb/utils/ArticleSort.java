package com.xbb.utils;

import com.xbb.pojo.Article;

import java.util.Comparator;

/**
 * @author shiex-薛
 * @title: ArticleSort
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\6\30 003013:58
 */
public class ArticleSort implements Comparator<Article> {

    /**
     * @description: 按照博客阅读量进行排序
     * @param o1
     * @param o2
     * @return: int
     */
    @Override
    public int compare(Article o1, Article o2) {
        if(o1.getReadCount() < o2.getReadCount())
            return 1;
        else return -1;
    }
}
