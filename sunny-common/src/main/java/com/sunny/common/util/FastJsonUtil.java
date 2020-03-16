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
     * @returnString
     */
    public static String toJSONString(Object object) {
        return JSONObject.toJSONString(object);
    }

    /**
     * JSON字符串转Object对象
     *
     * @param jsonStr
     * @return Object
     */
    public static <T> T toObject(String jsonStr, Class<T> type) {
        T t = JSON.parseObject(jsonStr, type);
        return t;
    }

    /**
     * JSON字符串转JSONObject
     *
     * @param jsonStr 字符串
     * @return JSONObject
     */
    public static <T> JSONObject toObject(String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        return jsonObject;
    }

    /**
     * JSON字符串转Map
     *
     * @param jsonStr 字符串
     * @return Map
     */
    public static <T> Map toMap(String jsonStr) {
        return JSON.parseObject(jsonStr);
    }

    /**
     * JSON字符串转JSONObject
     *
     * @param o 字符串
     * @return
     */
    public static <T> Map toMap(Object o) {
        Map<String, String> params = JSONObject.parseObject(
                o.toString(),
                new TypeReference<Map<String, String>>() {}
        );
        return params;
    }

}
