package com.cqupt.security.model;

import com.cqupt.security.entity.Authorities;
import com.cqupt.security.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @auther DyingZhang
 * @Create 2023-02-24 下午 10:20
 * @Discriptioon
 * 安全鉴权用户模板
 */
public class SecurityUsers implements UserDetails {

    private final Users users;

    public SecurityUsers(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();//创建权限集合
        for (int i = 0; i < users.getAuthorities().size(); i++) {
            int finalI = i;
            list.add(() -> users.getAuthorities().get(finalI).getAuthority());//添加权限集的实现类
        }
        return list;
    }

    public Integer getId() {
        return this.users.getId();
    }
    public void setId(Integer id) {
        this.users.setId(id);
    }
    @Override
    public String getPassword() {
        return this.users.getPassword();
    }

    public void setPassword(String password) {
        this.users.setPassword(password);
    }

    @Override
    public String getUsername() {
        return this.users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (this.users.getEnabled() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
