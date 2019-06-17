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

    /*
        getText()：从上传内容中获取所有文本内容
        Content：上传内容
        cutOutSize：指定获取文本大小，为0则返回全部文本
     */
    public static String getText(String Content, int cutOutSize)
    {
        StringBuffer countText = new StringBuffer();

        int count = 0;  // 长度计数
        String text = "";
        String strText = Content.replace("\n", " "); // 清空所有换行符
        String[] imgs = strText.split(">");

        for(String img : imgs)
        {
            if(!img.startsWith("<"))
            {
                int p1 = img.lastIndexOf('<'); // 文本内容长度
                if(p1 >= 0)
                {
                    count += p1;
                    text = img.substring(0, p1);// 截取出文本内容
                }
                else
                {
                    count += img.length();
                    text = img;
                }

                countText.append(text);
                if(cutOutSize != 0)
                {
                    if(count >= cutOutSize)
                    {
                        text = countText.substring(0, cutOutSize);
                        return text;
                    }
                }
            }
        }
        return countText.toString();
    }

    /*
        getImgUrls()：从上传内容中获取所有img路径（不包含Img字段）
        Content：上传内容
        splitText：splitText：分割点（一般依据ContextPath分割）
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

    /*
        removeImg：删除已上传并未提交图片
        content：上传内容
        imgUrls：已上传图片全部路径
        splitText：分割点（一般依据ContextPath分割）
        imgRoot：img存储父目录
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

    /*
        removeImg：删除已上传并未提交图片
        upload：上传图片
        iuuse：发布图片
        imgRoot：img存储父目录
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

    /*
        getText()：从KIndEditor上传内容中获取所有文本内容
        htmlContent：KIndEditor上传内容
        textSize：指定获取文本大小，若不指定则返回全部文字内容
        cutOutSize：从textSize文本中截取多少字符
     */
    /*public String getText(String Content, int textSize, int cutOutSize)
    {
        int count = 0;
        String countText = "";
        String[] imgs = Content.split(">");
        for(String img : imgs)
        {
            String text = "";
            if(!img.startsWith("<"))
            {
                int p1 = img.lastIndexOf('<'); // 文本内容长度
                if(p1 >= 0)
                {
                    count += p1;
                    text = img.substring(0, p1).replace("\n", " ");// 截取出文本内容，去除换行符
                }
                else
                {
                    text += img.replace("\n", " ");
                    count += text.length();
                }

                countText += text;
                if(count > textSize)
                {
                    countText = countText.substring(0, cutOutSize);
                    return countText;
                }
            }
        }
        return countText;
    }*/

    /*
        getImgUrls()：从KIndEditor上传内容中获取所有img路径（不包含Img字段）
        htmlContent：KIndEditor上传内容
     */
    /*public List<String> getImgUrls(String htmlContent)
    {
        List<String> list_imgs = new ArrayList<>();
        String[] imgs = htmlContent.split(">");
        for(String s : imgs)
        {
            String img = s.replace("\n", "");
            if(img.startsWith("<img"))
            {
                int p1 = img.indexOf('/');
                int p2 = img.indexOf('/', p1 + 1);
                String imgText = img.substring(p2 + 1);
                int p3 = imgText.indexOf('"');
                String imgUrl = imgText.substring(0, p3);
                list_imgs.add(imgUrl);
            }
        }
        return list_imgs;
    }

    *//*
        removeImg()：删除已上传且未提交的图片
        htmlContent：KIndEditor上传内容
        imgUrls：img路径内容
        splitContextPath：通过contextPath进行分割
        imgFileRoot：图片存储父目录（如：Request.getServletContext().getRealPath("/")）
     *//*
    public void removeImg(String htmlContent, String imgUrls, String splitText, String imgRoot)
    {
        String[] imgs = imgUrls.split(splitText);
        removeImg(htmlContent, imgs, imgRoot);
    }

    *//*
        removeImg()：删除已上传且未提交的图片
        htmlContent：KIndEditor上传内容
        imgUrls：上传图片路径数组（不包含ContextPath）
        imgFileRoot：图片存储父目录（如：Request.getServletContext().getRealPath("/")）
     *//*
    public void removeImg(String htmlContent, String[] imgUrls, String imgRoot)
    {
        List<String> imgs = new ArrayList(Arrays.asList(imgUrls));
        List<String> upload_imgs = imgs.subList(1, imgs.size());
        List<String> iuuse_imgs = getImgUrls(htmlContent);
        if(upload_imgs.size() > 0)
        {
            if(upload_imgs.size() > iuuse_imgs.size())
            {
                upload_imgs.removeAll(iuuse_imgs);
                File file = null;
                for(String imgUrl : upload_imgs)
                {
                    file = new File(imgRoot + imgUrl);
                    file.delete();
                }
            }
        }
    }*/

}
