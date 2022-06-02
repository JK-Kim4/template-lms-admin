package com.tutoedu.lmsadmin.web;


import com.tutoedu.lmsadmin.service.UserService;
import com.tutoedu.lmsadmin.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/auth/join")
    public String join(){
        return "contents/user/join";
    }

    @GetMapping("/auth/login")
    public String login(){
        return "contents/user/login";
    }

    @PostMapping("/auth/joinProc")
    public String joinProc(UserDto dto){
        userService.join(dto);

        return "redirect:/auth/login";
    }



}
