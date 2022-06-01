package com.tutoedu.lmsadmin.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final User user;

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /*계정 만료 여부
    * true :
    * false :
    * */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /*계정 잠김 여부
    * true :
    * false :
    * */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /*비밀번호 만료 여부
    * true :
    * false :
    * */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*사용자 사용 여부
    * true :
    * false :
    * */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /*사용자 권한 목록*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collector = new ArrayList<>();

        collector.add(() -> "ROLE_" + user.getRole());

        return collector;
    }
}
