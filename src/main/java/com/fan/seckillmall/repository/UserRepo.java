package com.fan.seckillmall.repository;

import com.fan.seckillmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Auther: zhengfan
 * Date: 2020/1/14
 */
@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username, String password);
}
