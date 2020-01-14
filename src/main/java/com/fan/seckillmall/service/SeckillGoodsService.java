package com.fan.seckillmall.service;

import com.fan.seckillmall.pojo.Goods;
import com.fan.seckillmall.pojo.SeckillGoods;
import com.fan.seckillmall.repository.SeckillGoodsRepo;
import com.fan.seckillmall.vo.SeckillGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Service
public class SeckillGoodsService {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SeckillGoodsRepo seckillGoodsRepo;

    public List<SeckillGoodsVO> list() {
        List<SeckillGoodsVO> seckillGoodsVOList = new ArrayList<>();
        List<SeckillGoods> allSeckillGoods = seckillGoodsRepo.findAll();
        for(SeckillGoods seckillGoods : allSeckillGoods) {
            Goods goods = goodsService.getById(seckillGoods.getGoodsId());
            if(goods != null) {
                SeckillGoodsVO seckillGoodsVO = this.getSeckillGoodsVO(goods,seckillGoods);
                seckillGoodsVOList.add(seckillGoodsVO);
            }
        }
        return seckillGoodsVOList;
    }

    private SeckillGoodsVO getSeckillGoodsVO(Goods goods, SeckillGoods seckillGoods) {
        SeckillGoodsVO seckillGoodsVO = new SeckillGoodsVO();
        seckillGoodsVO.setId(goods.getId());
        seckillGoodsVO.setName(goods.getName());
        seckillGoodsVO.setPrice(goods.getPrice());
        seckillGoodsVO.setImg(goods.getImg());
        seckillGoodsVO.setDesc(goods.getDescription());
        seckillGoodsVO.setSeckillCount(seckillGoods.getSeckillCount());
        seckillGoodsVO.setSeckillPrice(seckillGoods.getSeckillPrice());
        seckillGoodsVO.setStartTime(seckillGoods.getStartTime());
        seckillGoodsVO.setEndTime(seckillGoods.getEndTime());
        return seckillGoodsVO;
    }

}
