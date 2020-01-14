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
public class OrderInfo {
    @Id
    private String id;
    private String userName;
    private String userAddr;
    private String userPhone;
    private String goodsName;
    private Double goodsPrice;
    private Integer goodsCount;
    private Double totalAmount;
    private Integer state;
    private Date createTime;
    private Date updateTime;
}
