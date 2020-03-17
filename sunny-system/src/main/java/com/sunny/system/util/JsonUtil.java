package com.sunny.system.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * 序列化常用类
 *
 * @author chenye
 * @Data 2020-0316
 */
public class JsonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
    private static final String FORMAT4DISPLAY = "yyyy-MM-dd HH:mm:ss";

    public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance(FORMAT4DISPLAY);
    static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(FORMAT4DISPLAY));
    }

    private JsonUtil() {

    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            LOG.warn("serialize object has error", e);
        }
        return "";
    }

    public static <T> T fromJson(String content, Class<T> type) {
        try {
            return mapper.readValue(content, type);
        } catch (Exception e) {
            LOG.warn("serialize parse value[" + content + "] to object has error", e);
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public static <T> T fromJson(String content, TypeReference valueTypeRef) {
        try {
            return (T)mapper.readValue(content, valueTypeRef);
        } catch (Exception e) {
            LOG.warn("serialize parse value[" + content + "] to object has error", e);
            return null;
        }
    }

}
