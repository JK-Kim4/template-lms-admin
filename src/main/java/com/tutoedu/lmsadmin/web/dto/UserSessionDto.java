package com.tutoedu.lmsadmin.web.dto;

import com.tutoedu.lmsadmin.domain.user.Role;
import com.tutoedu.lmsadmin.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserSessionDto implements Serializable {

    private String username;
    private String nickname;
    private String password;
    private String email;
    private Role role;

    public UserSessionDto(User user){
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
}
