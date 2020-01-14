package com.fan.seckillmall.controller;

import com.fan.seckillmall.service.SeckillGoodsService;
import com.fan.seckillmall.vo.SeckillGoodsVO;
import com.fan.seckillmall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@RestController
@RequestMapping("/goods")
public class SeckillGoodsController {
    @Autowired
    private SeckillGoodsService seckillGoodsService;

    @GetMapping("/list")
    public ResponseVO list() {
        List<SeckillGoodsVO> goodsList = seckillGoodsService.list();
        return ResponseVO.seccess(goodsList);
    }
}
