package com.tutoedu.lmsadmin.service;

import com.tutoedu.lmsadmin.domain.user.CustomUserDetails;
import com.tutoedu.lmsadmin.domain.user.User;
import com.tutoedu.lmsadmin.domain.user.UserRepository;
import com.tutoedu.lmsadmin.web.dto.UserSessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    private final HttpSession session;


    /*사용자 정보 DB 조회*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new IllegalArgumentException("사용자가 존재하지 않습니다."));

        session.setAttribute("user", new UserSessionDto(user));

        return new CustomUserDetails(user);
    }
}
