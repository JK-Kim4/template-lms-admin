package com.tutoedu.lmsadmin;

import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.service.AuthorService;
import com.tutoedu.lmsadmin.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final AuthorService authorService;

    private final BookService bookService;

    @GetMapping(value = {"/index", "/"})
    public String index(){
        return "layouts/main_1";
    }

    @GetMapping("/login")
    public String login(){
        return "contents/user/login";
    }

    @GetMapping(value = "/author/list")
    public String authorList(Model model){

        List<Author> list = authorService.findAll();

        log.debug("author List findAll : {}", list.toArray());

        model.addAttribute("list", list);

        return "contents/author/list";
    }

    @GetMapping(value = "/author/save")
    public String insert(){
        return "contents/author/save";
    }

    @GetMapping(value="/book/list")
    public String bookList(Model model){

        model.addAttribute("list", bookService.findAll());

        return "contents/book/list";
    }

    @GetMapping(value = "/book/save")
    public String bookSave(Model model){

        model.addAttribute("authorList", authorService.findAll());

        return "contents/book/save";
    }

    @GetMapping("/test/author/list")
    @ResponseBody
    public HashMap<String, Object> bodyTest(){
        List<Author> list = authorService.findAll();

        log.debug("author List findAll : {}", list.toArray());

        HashMap<String, Object> result = new HashMap<>();
        result.put("result", list);
        return result;
    }
}
