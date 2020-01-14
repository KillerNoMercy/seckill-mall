package com.fan.seckillmall.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
public class CookieUtil {
    public static void add(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public static void add(HttpServletResponse response, String name, String value, Integer maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public static String get(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(name))
                return cookie.getValue();
        }
        return null;
    }
}
