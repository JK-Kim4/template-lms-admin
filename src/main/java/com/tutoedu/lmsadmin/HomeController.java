package com.tutoedu.lmsadmin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "layouts/main_1";
    }

    @GetMapping("/login")
    public String login(){
        return "contents/user/login";
    }

    @GetMapping("/class")
    public String classList(){
        return "contents/edu/list";}
}
