package com.fan.seckillmall.utils;

import com.alibaba.fastjson.JSON;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
public class JsonUtil {
    public static String toJson(Object obj) {
        return (String)JSON.toJSON(obj);
    }
}
