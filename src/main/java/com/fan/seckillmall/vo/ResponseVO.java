package com.fan.seckillmall.vo;

import lombok.Data;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Data
public class ResponseVO<T> {
    private Integer code;
    private String msg;
    private T data;

    private ResponseVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseVO success() {
        return new ResponseVO(200, "success", null);
    }

    public static <T> ResponseVO seccess(T data) {
        return new ResponseVO(200, "success", data);
    }

    public static ResponseVO fail() {
        return new ResponseVO(500, "fail", null);
    }

    public static <T> ResponseVO fail(String msg) {
        return new ResponseVO(500, msg, null);
    }
}
