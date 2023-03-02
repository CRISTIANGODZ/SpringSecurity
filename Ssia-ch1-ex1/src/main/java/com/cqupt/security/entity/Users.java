package com.cqupt.security.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2023-02-24 下午 10:12
 * @Discriptioon
 */
@Data
@NoArgsConstructor
public class Users {
    private Integer id;
    private String username;
    private String password;
    private Integer enabled;
    private List<Authorities> authorities;

}
