package com.fan.seckillmall.repository;

import com.fan.seckillmall.pojo.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Repository
public interface GoodsRepo extends JpaRepository<Goods,String> {
}
