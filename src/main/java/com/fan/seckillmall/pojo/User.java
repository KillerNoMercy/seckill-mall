package com.fan.seckillmall.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Entity
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String realName;
    private String addr;
    private String phone;
}
