package com.sunny.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

/**
 * @author chenye
 * @date 2020-0316
 */
public class FastJsonUtil {
    /**
     * Object转JSON字符串
     *
     * @param object 值
     * @return String
     */
    public static String toJSONString(Object object) {
        return JSONObject.toJSONString(object);
    }

    /**
     * JSON字符串转Object对象
     *
     * @param jsonStr 字符串
     * @return T
     */
    public static <T> T toObject(String jsonStr, Class<T> type) {
        return JSON.parseObject(jsonStr, type);
    }

    /**
     * JSON字符串转JSONObject
     *
     * @param jsonStr 字符串
     * @return JSONObject
     */
    public static JSONObject toObject(String jsonStr) {
        return JSONObject.parseObject(jsonStr);
    }

    /**
     * JSON字符串转Map
     *
     * @param jsonStr 字符串
     * @return Map
     */
    public static Map toMap(String jsonStr) {
        return JSON.parseObject(jsonStr);
    }

    /**
     * JSON字符串转JSONObject
     *
     * @param o 字符串
     * @return Map
     */
    public static Map toMap(Object o) {
        return JSONObject.parseObject(
                o.toString(),
                new TypeReference<Map<String, String>>() {
                }
        );
    }

}
