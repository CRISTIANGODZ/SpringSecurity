package com.cqupt.security.mapper;

import com.cqupt.security.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2023-02-25 上午 10:43
 * @Discriptioon
 */
@Mapper
public interface UsersMapper {

    /**
     * 获取所有的用户
     * @return
     */
    List<Users> getAllUsers();

    /**
     * 修改用户密码
     * @param users
     */
    void updateUserPassword(Users users);
}
