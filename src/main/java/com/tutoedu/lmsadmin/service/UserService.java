package com.tutoedu.lmsadmin.service;

import com.tutoedu.lmsadmin.domain.user.UserRepository;
import com.tutoedu.lmsadmin.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {


    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(UserDto dto){
        dto.setPassword(encoder.encode(dto.getPassword()));

        return userRepository.save(dto.toEntity()).getId();
    }


}
