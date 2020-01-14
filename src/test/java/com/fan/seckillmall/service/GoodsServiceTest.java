package com.fan.seckillmall.service;

import com.fan.seckillmall.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void getById() {
        Goods g2j0 = goodsService.getById("fh829");
        System.out.println(g2j0.getName());
    }
}