package com.tutoedu.lmsadmin;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
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
