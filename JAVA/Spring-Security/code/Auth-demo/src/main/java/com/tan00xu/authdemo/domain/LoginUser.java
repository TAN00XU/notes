package com.tan00xu.authdemo.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户登录
 *
 * @author 饮梦 TAN00XU
 * @date 2022/10/09 13:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {

    /**
     * 用户
     */
    private User user;

    /**
     * 权限
     */
    List<String> permissions;

    public LoginUser(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    @JSONField(serialize = false)
    List<SimpleGrantedAuthority> authorities;

    /**
     * 得到权限
     *
     * @return {@link Collection}<{@link ?} {@link extends} {@link GrantedAuthority}>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }
        /**
         * List<SimpleGrantedAuthority> list = new ArrayList<>();
         *         for (String permission : permissions) {
         *             SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission);
         *             list.add(simpleGrantedAuthority);
         *         }
         */

        List<SimpleGrantedAuthority> collect = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
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
        return true;
    }
}
