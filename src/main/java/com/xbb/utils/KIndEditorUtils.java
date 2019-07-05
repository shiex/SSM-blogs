package com.xbb.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 处理文本内容以及图片问题
 * @title: KIndEditorUtils
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\23 002318:00
 */
public class KIndEditorUtils {

    /**
     * @description: 从发布内容中获取所有文本内容
     * @param Content 发布内容
     * @param cutOutSize 指定获取文本大小，为0则返回全部文本
     * @return: java.lang.String
     */
    public static String getText(String Content, int cutOutSize)
    {
        StringBuffer countText = new StringBuffer();

        String text = "";
        String strText = Content.replace("\n", " "); // 清空所有换行符
        String[] imgs = strText.split(">");

        for(String img : imgs)
        {
            if(!img.startsWith("<")) {
                int p1 = img.lastIndexOf('<'); // 文本内容长度
                if(p1 >= 0) {
                    text = img.substring(0, p1);// 截取出文本内容
                }
                else {
                    text = img;
                }

                countText.append(text);
                if(cutOutSize > 0) {
                    if(text.length() > cutOutSize) {
                        return countText.substring(0, cutOutSize);
                    }
                }
            }
        }
        return countText.toString();
    }

    // 删除已上传并未提交的多余图片
        /*String imgUrls = article.getImgUrls();
        List<String> upload = KIndEditorUtils.getImgUrls(article.getContent(), StatusCode.CONTEXT_PATH);
        List<String> iuuse = KIndEditorUtils.getImgUrls(imgUrls, StatusCode.CONTEXT_PATH);
        KIndEditorUtils.removeImg(upload, iuuse, StatusCode.WEB_FILE_ROOT);*/

    /**
     * @description: 从发布内容中提取图片路径
     * @param content
     * @param contextPath
     * @return: java.util.List<java.lang.String>
     */
    public static List<String> getImgUrls(String content, String contextPath)
    {
        List<String> list_imgs = new ArrayList<>();
        String[] imgs = content.split(contextPath);
        for(int i = 1; i < imgs.length; i++)
        {
            int p1 = imgs[i].indexOf("\"");
            if(p1 < 0)
                list_imgs.add(imgs[i]);
            else
                list_imgs.add(imgs[i].substring(0, p1));
        }
        return list_imgs;
    }

    /**
     * @description: 删除富文本已上传未提交图片
     * @param content 发布内容
     * @param imgUrls 上传图片路径
     * @param contextPath 请求路径
     * @param imgRoot 图片存储父目录
     * @return: void
     */
    public static void removeImg(String content, String imgUrls,String contextPath, String imgRoot)
    {
        if(content == null && imgUrls == null && contextPath == null
                && imgRoot == null) return;

        List<String> upload = getImgUrls(imgUrls, contextPath);
        List<String> iuuse = getImgUrls(content, contextPath);
        if(upload.size() == iuuse.size()) return;
        removeImg(upload, iuuse, imgRoot);
    }

    /**
     * @description: 删除富文本内容已发布未提交图片
     * @param upload 上传图片
     * @param iuuse 发布图片
     * @param imgRoot 图片存储父目录
     * @return: void
     */
    public static void removeImg(List<String> upload, List<String> iuuse, String imgRoot)
    {
        if(upload.size() > 0)
        {
            if(upload.size() > iuuse.size())
            {
                upload.removeAll(iuuse);
                File file = null;
                for(String imgPath : upload)
                {
                    file = new File(imgRoot + imgPath);
                    file.delete();
                }
            }
        }
    }

}
