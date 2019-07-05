package com.xbb.utils;

/**
 * @author Administrator
 * @title: StatusCode
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001715:31
 */
public class StatusCode {

    public static String CONTEXT_PATH; // 项目实际部署路径

    public static String WEB_FILE_ROOT; // 项目存储路径

    public final static int SUCCEED = 0; // 成功

    public final static int FAILER = -1; // 出错

    public final static String ERROR = "error"; // 应答状态码

    public final static String REASON = "reason"; // 应答消息

    public final static String IMGS_ROOT = "static/userImgs/"; // 用户图片存储父目录

    public final static String IMG_TYPE = "png,jpeg,jpg,bmp,psd,swf,svg"; // 支持上传的图片类型

    public static final int IMG_SIZE_MAX = 10 * 1024 * 1024;    // 图片上传限制大小

    public final static String TEMPLATE_ROOT = "/template/"; // 模板文件父目录

    public final static String PAGES_ROOT = "/static/pages/article/"; // 博客静态页面存储父目录

    public final static String ARTICLE_READ = "article/read/%d.html"; // 阅读博客url

    public final static String SESSION_USER = "SESSION_USER"; // 用户Session Key

    public static final String MD5 = "MD5";

    public final static String MESSAGE = "message"; // 富文本应答消息

}
