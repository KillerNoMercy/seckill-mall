package com.fan.seckillmall.service;

import com.fan.seckillmall.pojo.Goods;
import com.fan.seckillmall.pojo.SeckillGoods;
import com.fan.seckillmall.repository.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Optional;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsRepo goodsRepo;

    public Goods getById(String goodsId) {
        if(StringUtils.isEmpty(goodsId))
            throw new RuntimeException("goodsId is null");
        Optional<Goods> goodsOptional = goodsRepo.findById(goodsId);
        if (!goodsOptional.isPresent())
            return null;
        return goodsOptional.get();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Goods updateStock(String goodsId, Integer count) {
        if(StringUtils.isEmpty(goodsId) || count == null)
            return null;
        Optional<Goods> byId = goodsRepo.findById(goodsId);
        if(byId.isPresent()){
            Goods goods = byId.get();
            goods.setStock(goods.getStock() - count);
            goods.setUpdateTime(new Date());
            return goodsRepo.save(goods);
        }
        return null;
    }
}
