package com.fan.seckillmall.vo;

import lombok.Data;

import java.util.Date;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Data
public class SeckillGoodsVO {
    private String id;
    private String name;
    private Double price;
    private String desc;
    private String img;
    private Double seckillPrice;
    private Integer seckillCount;
    private Date startTime;
    private Date endTime;
}
