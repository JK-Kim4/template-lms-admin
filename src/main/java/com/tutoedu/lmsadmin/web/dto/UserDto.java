package com.tutoedu.lmsadmin.web.dto;

import com.tutoedu.lmsadmin.domain.user.Role;
import com.tutoedu.lmsadmin.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * UserDto class
 * 사용자 정보 전달 Object
 * */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UserDto {

    private String username;
    private String nickname;
    private String password;
    private String email;
    private Role role;


    /*전달받은 UserDto -> User Entity로 변환*/
    public User toEntity(){
        User user = User.builder()
                .username(username)
                .nickname(nickname)
                .password(password)
                .email(email)
                .role(role.USER)
            .build();
        return user;
    }
}
