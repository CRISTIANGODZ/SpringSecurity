package com.cqupt.security.service.impl;

import com.cqupt.security.config.MyUserDetailsService;
import com.cqupt.security.entity.Users;
import com.cqupt.security.mapper.UsersMapper;
import com.cqupt.security.model.SecurityUsers;
import com.cqupt.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2023-03-02 下午 7:35
 * @Discriptioon
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;

    @Autowired
    public MyUserDetailsService myUserDetailsService;

    /**
     * 创建用户
     * @param users
     */
    @Override
    public void createUser(Users users) {
        return;
    }

    /**
     * 修改用户
     * @param users
     */
    @Override
    public void updateUserPassword(Users users) {
        myUserDetailsService.updateUser(new SecurityUsers(users));
        usersMapper.updateUserPassword(users);
    }
}
