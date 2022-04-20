package com.tutoedu.lmsadmin.web;

import com.tutoedu.lmsadmin.service.AuthorService;
import com.tutoedu.lmsadmin.web.dto.AuthorInsertRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @PostMapping(value = "/insert")
    public HashMap<String, Object> insertP(@RequestBody AuthorInsertRequestDto requestDto){
        HashMap<String, Object> resultMap = new HashMap<>();
        log.debug("##################### AuthorController@insertP #####################");
        log.debug(" author insert @ RequestBody : {}", requestDto.toString());
        int result = authorService.insert(requestDto);


        return resultMap;
    }
}
