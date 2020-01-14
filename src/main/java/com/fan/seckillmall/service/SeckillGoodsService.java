package com.fan.seckillmall.service;

import com.fan.seckillmall.pojo.Goods;
import com.fan.seckillmall.pojo.SeckillGoods;
import com.fan.seckillmall.repository.GoodsRepo;
import com.fan.seckillmall.repository.SeckillGoodsRepo;
import com.fan.seckillmall.vo.SeckillGoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Service
public class SeckillGoodsService {
    @Autowired
    private GoodsRepo goodsRepo;
    @Autowired
    private SeckillGoodsRepo seckillGoodsRepo;

    public List<SeckillGoodsVO> list() {
        List<SeckillGoodsVO> seckillGoodsVOList = new ArrayList<>();
        List<SeckillGoods> allSeckillGoods = seckillGoodsRepo.findAll();
        for(SeckillGoods seckillGoods : allSeckillGoods) {
            Optional<Goods> byId = goodsRepo.findById(seckillGoods.getGoodsId());
            if(byId.isPresent()) {
                Goods goods = byId.get();
                SeckillGoodsVO seckillGoodsVO = this.getSeckillGoodsVO(goods,seckillGoods);
                seckillGoodsVOList.add(seckillGoodsVO);
            }
        }
        return seckillGoodsVOList;
    }

    private SeckillGoodsVO getSeckillGoodsVO(Goods goods, SeckillGoods seckillGoods) {
        SeckillGoodsVO seckillGoodsVO = new SeckillGoodsVO();
        BeanUtils.copyProperties(goods, seckillGoodsVO);
        BeanUtils.copyProperties(seckillGoods, seckillGoodsVO);
        return seckillGoodsVO;
    }
}
