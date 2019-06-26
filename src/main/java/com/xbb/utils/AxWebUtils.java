package com.xbb.utils;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @author Administrator
 * @title: AxWebUtils
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\23 002318:05
 */
public class AxWebUtils {

    /**
     * @description: 解析Restful风格所提交的数据
     * @param in 数据包
     * @param charset 字符集
     * @param maxSize 上传限制
     * @return: java.lang.String
     */
    public static String queryString(InputStream in, String charset, int maxSize) throws Exception
    {
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream(1024 * 16);
        byte [] data = new byte[1024];
        int numOfWait = 0;
        while(true)
        {
            int n = in.read(data);
            if(n < 0) break;  // 数据已读取完毕
            if(n == 0)
            {
                if(numOfWait++ >= 3)  // 此种情况不得连续超过3次
                    break;
                try
                {
                    Thread.sleep(5);
                }catch (Exception e)
                {
                }
                continue;  // 数据未完
            }
            arrayOut.write(data, 0, n); // 存入缓冲区
            if(arrayOut.size() > maxSize)
                break;
        }
        return arrayOut.toString(charset);
    }

    /**
     * @description: 解析GET请求附带参数
     * @param query 前端所发送参数
     * @param charset 指定字符集
     * @return: java.util.HashMap<java.lang.String,java.lang.Object>
     */
    public static HashMap<String, Object> queryParams(String query,String  charset)
    {
        HashMap <String, Object> params = new HashMap<>();
        if(query == null) return params;

        String[] ppp = query.split("&");
        for(String p : ppp)
        {
            String[] kv = p.split("=");
            String key = kv[0];
            String value = kv[1];
            if(value.indexOf('%') >= 0)  // 如果存在百分号，则进行URL解码
            {
                try{
                    URLEncoder.encode(value, charset);
                }catch (Exception e){}
            }
            params.put(key, value);
        }
        return params;
    }

    /**
     * @description: 返回js文件||json格式数据
     * @param data json格式数据
     * @param dataName var对象名称
     * @param isJsonOrJs 默认返回js文件数据
     * @return: java.lang.String
     */
    public static String JsxData(JSONObject data, String dataName, Boolean isJsonOrJs) {
        String strResp = null;
        Boolean isJSONFormat = false;

        if(isJsonOrJs != null) isJSONFormat = isJsonOrJs;

        if(isJSONFormat)
        {
            if(data == null)
                strResp = "";
            else
                strResp = data.toString();
        }
        else {
            if(data == null)
                strResp = "var " + dataName + " = null";
            else
                strResp = "var " + dataName + " = " + data.toString() + ";";
        }
        return strResp;
    }
}
