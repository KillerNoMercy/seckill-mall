package com.fan.seckillmall.service;

import com.fan.seckillmall.pojo.User;
import com.fan.seckillmall.repository.UserRepo;
import com.fan.seckillmall.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return null;
        }
        password = MD5Util.md5(password);
        return userRepo.findByUsernameAndPassword(username, password);
    }

}
