package com.fan.seckillmall.controller;

import com.fan.seckillmall.pojo.SeckillOrder;
import com.fan.seckillmall.service.SeckillService;
import com.fan.seckillmall.vo.ResponseVO;
import com.fan.seckillmall.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@RestController
@RequestMapping("/seckill")
public class SeckillController {
    @Autowired
    private SeckillService seckillService;

    @PostMapping("/order")
    public ResponseVO order(UserVO userVO, @RequestParam String goodsId, @RequestParam Integer count) {
        if(userVO == null)
            return ResponseVO.fail("请先登录");
        SeckillOrder seckillOrder = seckillService.create(userVO, goodsId, count);
        return seckillOrder != null?ResponseVO.seccess(seckillOrder) : ResponseVO.fail();
    }
}
