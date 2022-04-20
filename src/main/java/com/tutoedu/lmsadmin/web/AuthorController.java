package com.tutoedu.lmsadmin.web;

import com.tutoedu.lmsadmin.service.AuthorService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

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
        HashMap<String, Object> resultMap = new HashMap<>();


        return resultMap;
    }
}
