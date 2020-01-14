package com.fan.seckillmall.service;

import com.fan.seckillmall.pojo.Goods;
import com.fan.seckillmall.pojo.OrderInfo;
import com.fan.seckillmall.repository.OrderRepo;
import com.fan.seckillmall.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Transactional(propagation = Propagation.SUPPORTS)
    public OrderInfo create(UserVO userVO, Goods goods, Integer count, BigDecimal totalAmunt) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(UUID.randomUUID().toString());
        orderInfo.setUserName(userVO.getRealName());
        orderInfo.setUserPhone(userVO.getPhone());
        orderInfo.setUserAddr(userVO.getAddr());
        orderInfo.setGoodsName(goods.getName());
        orderInfo.setGoodsPrice(goods.getPrice());
        orderInfo.setGoodsCount(count);
        orderInfo.setTotalAmount(totalAmunt.doubleValue());
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        orderRepo.save(orderInfo);
        return orderInfo;
    }
}
