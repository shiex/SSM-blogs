package com.xbb.utils;

import com.xbb.pojo.Article;

import java.util.List;
import java.util.Random;

/**
 * @author shiex-薛
 * @title: ArticleUtlis
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\6\26 002622:07
 */
public class ArticleUtlis {

    public static Random random = new Random();

    /**
     * @description: 标题控制在22字数内
     * @param articles
     * @return: void
     */
    public static void setTitle(List<Article> articles){
        if(articles.size() > 0){
            for(Article article : articles){
                if(article.getTitle().length() > 15){
                    int n = random.nextInt(15) + 7;
                    String title = article.getTitle().substring(0,n);
                    article.setTitle(title);
                }
            }
        }
    }
}
