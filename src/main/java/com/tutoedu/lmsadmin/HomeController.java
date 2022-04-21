package com.tutoedu.lmsadmin;

import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final AuthorService authorService;

    @GetMapping(value = {"/index", "/"})
    public String index(){
        return "layouts/main_1";
    }

    @GetMapping("/login")
    public String login(){
        return "contents/user/login";
    }

    @GetMapping(value = "/author/list")
    public String listG(Model model){

        List<Author> list = authorService.findAll();

        log.debug("author List findAll : {}", list.toArray());

        model.addAttribute("list", list);

        return "contents/author/list";
    }

    @GetMapping(value = "/author/save")
    public String insertG(){
        return "contents/author/save";
    }
}
