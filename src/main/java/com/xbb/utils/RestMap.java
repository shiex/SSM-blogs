package com.xbb.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @title: ResponseMap
 * @projectName SSM-blogs
 * @description: TODO
 * @date 2019\3\17 001717:05
 */
public class RestMap {

    /**
     * @description: restMap默认应答成功
     * @param
     * @return: java.util.Map
     */
    public static Map getRestMap()
    {
        Map <String, Object> restMap = new HashMap<>();
        restMap.put(StatusCode.ERROR, StatusCode.SUCCEED);
        restMap.put(StatusCode.REASON, "OK");
        return restMap;
    }

    /**
     * @description: 修改restMap应答状态
     * @param restMap
     * @param reason 原因
     * @return: void
     */
    public static void setRestMap(Map restMap, String reason)
    {
        restMap.put(StatusCode.ERROR, StatusCode.FAILER);
        restMap.put(StatusCode.REASON, reason);
    }
}
