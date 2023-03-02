package com.cqupt.security.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @auther DyingZhang
 * @Create 2023-02-23 下午 6:47
 * @Discriptioon
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @RolesAllowed("ADMIN")
    public String hello(Authentication user) {
        String str = "hello, " + user.getName() + "!";
        return str;
    }

    @GetMapping("/manager")
    @RolesAllowed("MANAGER")
    public String helloManager(Authentication user) {
        String str = "hello, Manager " + user.getName() + "!";
        return str;
    }

}
