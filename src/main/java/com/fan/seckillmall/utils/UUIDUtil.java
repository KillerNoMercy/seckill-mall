package com.fan.seckillmall.utils;

import java.util.UUID;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
public class UUIDUtil {
    public static String get(String source) {
        return UUID.randomUUID().toString();
    }
}
