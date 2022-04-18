package com.tutoedu.lmsadmin.web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("test")
@Log4j2
@Controller
public class TestController {

    @GetMapping("/index")
    public String index(){
        return "contents/main_1";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/class")
    public String classList(){
        return "class/list";}
}
