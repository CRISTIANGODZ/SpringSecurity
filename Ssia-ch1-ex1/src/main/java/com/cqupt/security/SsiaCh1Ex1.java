package com.cqupt.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * @auther DyingZhang
 * @Create 2023-02-23 下午 6:46
 * @Discriptioon
 */

@SpringBootApplication
@EnableAsync
public class SsiaCh1Ex1 {
    public static void main(String[] args) {
        SpringApplication.run(SsiaCh1Ex1.class, args);
    }
}
