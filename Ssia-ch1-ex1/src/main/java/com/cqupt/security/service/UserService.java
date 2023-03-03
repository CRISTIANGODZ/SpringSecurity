package com.cqupt.security.service;

import com.cqupt.security.entity.Users;
import org.springframework.security.core.Authentication;

/**
 * @auther DyingZhang
 * @Create 2023-03-02 下午 7:35
 * @Discriptioon
 */
public interface UserService {

    /**
     * 创建用户
     * @param users
     */
    void createUser(Users users);

    /**
     * 修改用户
     * @param users
     */
    void updateUserPassword(Users users);
}
