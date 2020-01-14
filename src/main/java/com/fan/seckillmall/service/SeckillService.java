package com.fan.seckillmall.service;

import com.fan.seckillmall.pojo.Goods;
import com.fan.seckillmall.pojo.SeckillGoods;
import com.fan.seckillmall.pojo.SeckillOrder;
import com.fan.seckillmall.repository.SeckillGoodsRepo;
import com.fan.seckillmall.repository.SeckillOrderRepo;
import com.fan.seckillmall.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Service
public class SeckillService {
    @Autowired
    private SeckillOrderRepo seckillOrderRepo;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SeckillGoodsRepo seckillGoodsRepo;

    @Transactional
    public SeckillOrder create(UserVO userVO, String goodsId, Integer count) {
        // 创建秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setId(UUID.randomUUID().toString());
        seckillOrder.setUserId(userVO.getId());
        Goods goods = goodsService.getById(goodsId);
        if(goods == null)
            return null;
        BigDecimal totalAmount = new BigDecimal(goods.getPrice()).multiply(new BigDecimal(count));
        // 创建订单
        String orderId = orderService.create(userVO, goods, count, totalAmount).getId();
        seckillOrder.setOrderId(orderId);
        seckillOrder.setCreateTime(new Date());
        seckillOrder.setUpdateTime(new Date());
        seckillOrderRepo.save(seckillOrder);
        // 扣库存
        Goods updateGoods = goodsService.updateStock(goodsId, count);
        // 创建秒杀订单
        SeckillGoods seckillGoods = seckillGoodsRepo.findByGoodsId(goodsId);
        seckillGoods.setSeckillCount(seckillGoods.getSeckillCount() - count);
        seckillGoodsRepo.save(seckillGoods);
        return updateGoods == null ? null : seckillOrder;
    }
}
