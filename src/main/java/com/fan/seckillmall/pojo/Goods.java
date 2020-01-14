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
public class Goods {
    @Id
    private String id;
    private String name;
    private Double price;
    private String desc;
    private String img;
    private Integer stock;
    private Integer state;
    private Date createTime;
    private Date updateTime;
}
