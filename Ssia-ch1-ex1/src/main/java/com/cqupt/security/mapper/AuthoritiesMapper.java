package com.cqupt.security.mapper;

import com.cqupt.security.entity.Authorities;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2023-02-25 上午 10:44
 * @Discriptioon
 */
@Mapper
public interface AuthoritiesMapper {

    /**
     * 根据id获取所有权限
     * @param username
     * @return
     */
    List<Authorities> getAuthoritiesById(@Param("username") String username);
}
