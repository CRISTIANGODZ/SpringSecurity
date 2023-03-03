package com.cqupt.security.config;

import com.cqupt.security.mapper.UsersMapper;
import com.cqupt.security.model.SecurityUsers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @auther DyingZhang
 * @Create 2023-02-24 下午 8:24
 * @Discriptioon
 * UserDetailsService的实现
 */
public class MyUserDetailsService implements UserDetailsManager {

    private final List<UserDetails> users;

    public MyUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst().orElseThrow(() -> new UsernameNotFoundException("Users not find!"));
    }

    @Override
    public void createUser(UserDetails userDetails) {

    }

    @Override
    public void updateUser(UserDetails userDetails) {//修改内存中的用户详情
        Optional<UserDetails> details = users.stream().filter(user -> user.getUsername().equals(userDetails.getUsername())).findFirst();
        UserDetails userDetailsInRAM = details.get();//找到匹配的内存中的用户
        users.remove(userDetailsInRAM);//删除内存中的该用户节点
        if (userDetailsInRAM instanceof SecurityUsers) {
            SecurityUsers securityUserDetailsInRAM = (SecurityUsers) userDetails;//只有我们重写的UserDetails才能修改密码，所以要完成类型匹配和转换
            securityUserDetailsInRAM.setPassword(userDetails.getPassword());
            users.add(userDetailsInRAM);//将用户重新加载入内存中
        } else {
            throw new RuntimeException("鉴权模板不匹配！");
        }
    }

    @Override
    public void deleteUser(String s) {

    }

    @Override
    public void changePassword(String s, String s1) {

    }

    @Override
    public boolean userExists(String s) {
        return false;
    }

}
