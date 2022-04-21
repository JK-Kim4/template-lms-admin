package com.tutoedu.lmsadmin.web;

import com.tutoedu.lmsadmin.service.AuthorService;
import com.tutoedu.lmsadmin.web.dto.AuthorSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping(value = "/author/api")
@RequiredArgsConstructor
public class AuthorApiController {

    private final AuthorService authorService;

    @ResponseBody
    @PostMapping(value = "/save")
    public Long save(@RequestBody AuthorSaveRequestDto requestDto){

        log.debug("Author save request : {}", requestDto.toString());

        Long result = authorService.save(requestDto);

        log.debug("Author save result : {}", result);

        return result;
    }
}
