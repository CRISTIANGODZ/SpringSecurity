package com.cqupt.security.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2023-02-24 下午 8:24
 * @Discriptioon
 * UserDetailsService的实现
 */
public class MyUserDetailsService implements UserDetailsService {

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

}
