package com.fan.seckillmall.utils;

import org.springframework.util.DigestUtils;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
public class MD5Util {
    public static String md5(String s) {
        return DigestUtils.md5DigestAsHex(s.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(md5("123"));
    }
}
