package com.fan.seckillmall.controller;

import com.fan.seckillmall.common.Commons;
import com.fan.seckillmall.service.SeckillGoodsService;
import com.fan.seckillmall.vo.SeckillGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Controller
@RequestMapping("/goods")
public class SeckillGoodsController {
    @Autowired
    private SeckillGoodsService seckillGoodsService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    @GetMapping("/list")
    public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
        String listHtml = redisTemplate.opsForValue().get(Commons.HTML_LIST);
        if(listHtml != null)
            return listHtml;
        List<SeckillGoodsVO> goodsList = seckillGoodsService.list();
        model.addAttribute("goodsList", goodsList);
        WebContext webContext = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        listHtml = thymeleafViewResolver.getTemplateEngine().process("list", webContext);
        redisTemplate.opsForValue().set(Commons.HTML_LIST, listHtml, 1);
        return listHtml;
    }
}
