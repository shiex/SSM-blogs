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

    public static Map getRestMap()
    {
        Map <String, Object> map = new HashMap<>();
        map.put("error", StatusCode.SUCCEED);
        map.put("reason", "OK");
        return map;
    }
}
