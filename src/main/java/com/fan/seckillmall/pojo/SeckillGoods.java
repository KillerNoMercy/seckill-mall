package com.fan.seckillmall.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Entity
@Data
public class SeckillGoods {
    @Id
    private String id;
    private String goodsId;
    private Double seckillPrice;
    private Integer seckillCount;
    private Date startTime;
    private Date endTime;
}
