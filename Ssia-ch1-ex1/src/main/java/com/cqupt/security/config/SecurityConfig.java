package com.cqupt.security.config;

import com.cqupt.security.mapper.UsersMapper;
import com.cqupt.security.entity.Users;
import com.cqupt.security.model.SecurityUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


/**
 * @auther DyingZhang
 * @Create 2023-02-23 下午 6:48
 * @Discriptioon
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UsersMapper usersMapper;

    @Bean
    public MyUserDetailsService userDetailsService() {//注入用户细节服务
        ArrayList<UserDetails> list = new ArrayList<>();
        List<Users> allUsers = usersMapper.getAllUsers();
        for (Users user : allUsers) {
            list.add(new SecurityUsers(user));
        }
        return new MyUserDetailsService(list);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }//注入编码器

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();//使用了httpBasic身份验证模式（实际生产中不能用此模式）
        http.authorizeRequests()//认证请求
                .antMatchers("/templates/**").permitAll()//放行静态资源
                .anyRequest().authenticated()//所有请求都要被认证
                .and()
                .formLogin()
                .loginPage("/templates/login.html")
                .loginProcessingUrl("/login")
//                .successForwardUrl("/templates/index.html")//
                .and().csrf().disable();//与form表单的action相同

    }

}
