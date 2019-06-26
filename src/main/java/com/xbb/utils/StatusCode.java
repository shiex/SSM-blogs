package com.xbb.utils;

/**
 * @author Administrator
 * @title: StatusCode
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001715:31
 */
public class StatusCode {

    /*
        项目实际部署路径
     */
    public static String CONTEXT_PATH;

    /*
        项目存储路径
     */
    public static String WEB_FILE_ROOT;

    /*
        博客上传资源图片父目录
     */
    public final static String ARTICLE_IMG_ROOT = "static/article/img/";

    /*
        用户上传头像父目录
     */
    public final static String USER_IMG_ROOT = "static/user/img/";

    /*
        支持上传的图片类型
     */
    public final static String IMG_TYPE = "png,jpeg,jpg,gif,bmp,psd,swf,svg";

    /*
        生成静态文件父目录
     */

    public final static String VIEW_ROOT = "/view/";
    /*
        模板文件父目录
     */
    public final static String TEMPLATE_ROOT = "/view/template/";

    /*
        博客静态页面存储父目录
     */
    public final static String ARTICLE_ROOT = "/view/article/";

    /*
        请求成功
     */
    public final static int SUCCEED = 0;

    /*
        请求失败
     */
    public final static int FAILER = -1;

    /*
        用户图片存储父目录
     */
    public final static String USER_IMGS_ROOT = "static/userImgs/";

    /*
        Session
     */
    public final static String SESSION_USER = "SESSION_USER";

}
