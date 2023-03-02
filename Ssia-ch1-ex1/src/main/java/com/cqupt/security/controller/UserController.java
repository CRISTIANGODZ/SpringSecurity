package com.cqupt.security.controller;

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


    @PostMapping("/create")
    public String createUser() {
        return null;
    }

    @GetMapping("/update")
    public String updateUser() {
        return null;
    }

}
