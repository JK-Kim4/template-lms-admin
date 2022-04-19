package com.tutoedu.lmsadmin.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "/author")
public class AuthorController {

    @GetMapping(value = "/list")
    public String list(){
        return "contents/author/list";
    }

    @GetMapping(value = "/insert")
    public String insert(){
        return "contents/author/insert";
    }
}
