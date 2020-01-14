package com.fan.seckillmall.intercepter;

import com.alibaba.fastjson.JSON;
import com.fan.seckillmall.common.Commons;
import com.fan.seckillmall.utils.CookieUtil;
import com.fan.seckillmall.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserVO.class) == true;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String token = CookieUtil.get(request, Commons.TOKEN);
        String userInfo = redisTemplate.opsForValue().get(String.format(Commons.TOKEN_ID, token));
        if (StringUtils.isEmpty(userInfo))
            throw new RuntimeException("该用户不存在");
        return JSON.parseObject(userInfo, UserVO.class);
    }
}
