package com.fan.seckillmall.repository;

import com.fan.seckillmall.pojo.SeckillGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Repository
public interface SeckillGoodsRepo extends JpaRepository<SeckillGoods,String> {
    SeckillGoods findByGoodsId(String goodsId);
}
