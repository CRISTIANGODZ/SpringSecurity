package com.cqupt.security.controller;

import com.cqupt.security.entity.Users;
import com.cqupt.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther DyingZhang
 * @Create 2023-03-02 下午 7:27
 * @Discriptioon
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public String createUser(Users users) {
        userService.createUser(users);
        return null;
    }

    @PostMapping("/update")
    public String updateUserPassword(Users users) {
        userService.updateUserPassword(users);
        return null;
    }

}
