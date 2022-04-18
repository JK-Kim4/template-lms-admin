package com.tutoedu.lmsadmin.web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/cls")
public class ClsController {

    @GetMapping("/insert")
    public String insert(){
        return "cls/insert";
    }
}
