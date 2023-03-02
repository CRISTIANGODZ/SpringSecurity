package com.cqupt.security.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther DyingZhang
 * @Create 2023-02-24 下午 10:14
 * @Discriptioon
 */
@Data
@NoArgsConstructor
public class Authorities {
    private Integer id;
    private String username;
    private String authority;
}
