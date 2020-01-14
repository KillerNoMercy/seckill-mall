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
public class SeckillOrder {
    @Id
    private String id;
    private String orderId;
    private String userId;
    private Date createTime;
    private Date updateTime;
}
