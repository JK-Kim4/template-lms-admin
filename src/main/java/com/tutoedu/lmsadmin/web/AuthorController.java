package com.tutoedu.lmsadmin.web;

import com.tutoedu.lmsadmin.service.AuthorService;
import com.tutoedu.lmsadmin.web.dto.AuthorSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/save")
    public String insertG(){
        return "contents/author/save";
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public Long save(@RequestBody AuthorSaveRequestDto requestDto){
        return authorService.save(requestDto);
    }
}
