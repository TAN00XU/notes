package com.tan00xu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonUtils {

    public static String getJson(Object object) {
        return JsonUtils.getJson(object, "yyyy-MM-dd HH:mm:ss");
    }
    public static String getJson(Object object, String simpleDateFormat) {
        ObjectMapper objectMapper = new ObjectMapper();
        Date date = new Date();

        //使用ObjectMapper关闭格式化为时间戳，默认是true
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
        //通过setDateFormat设置日期格式
        objectMapper.setDateFormat(sdf);

        //ObjectMapper解析时间后的默认格式为：TimeStamp,时间戳格式
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
