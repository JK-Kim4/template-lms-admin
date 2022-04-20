package com.tutoedu.lmsadmin.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@Slf4j
@RequestMapping(value = "/author")
public class AuthorController {

    @GetMapping(value = "/list")
    public String listG(){
        return "contents/author/list";
    }

    @GetMapping(value = "/insert")
    public String insertG(){
        return "contents/author/insert";
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public HashMap<String, Object> insertP(){
        return null;
    }
}
