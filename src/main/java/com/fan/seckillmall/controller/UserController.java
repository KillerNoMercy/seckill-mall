package com.fan.seckillmall.controller;

import com.alibaba.fastjson.JSON;
import com.fan.seckillmall.bo.LoginBO;
import com.fan.seckillmall.common.Commons;
import com.fan.seckillmall.pojo.User;
import com.fan.seckillmall.service.UserService;
import com.fan.seckillmall.utils.CookieUtil;
import com.fan.seckillmall.utils.UUIDUtil;
import com.fan.seckillmall.vo.ResponseVO;
import com.fan.seckillmall.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/login")
    public ResponseVO login(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginBO loginBO) {
        // 校验 如果redis有用户信息就取出返回
        if(loginBO == null)
            return ResponseVO.fail();
        String userToken = CookieUtil.get(request, Commons.TOKEN);
        if(userToken != null) {
            String userVoString = redisTemplate.opsForValue().get(String.format(Commons.TOKEN_ID, userToken));
            if(!StringUtils.isEmpty(userVoString)) {
                return ResponseVO.seccess(JSON.parseObject(userVoString, UserVO.class));
            }
        }
        User user = userService.login(loginBO.getUsername(), loginBO.getPassword());
        if(user == null)
            return ResponseVO.fail("登录失败");
        // 写入token
        String token = UUIDUtil.get(user.getUsername());
        CookieUtil.add(response, Commons.TOKEN, token);
        // redis缓存用户信息
        UserVO userVO = this.user2UserVO(user);
        redisTemplate.opsForValue().set(String.format(Commons.TOKEN_ID, token), JSON.toJSONString(userVO));
        return ResponseVO.seccess(userVO);
    }

    private UserVO user2UserVO(User user) {
        if(user == null)
            throw new RuntimeException();
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
