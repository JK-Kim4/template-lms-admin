package com.tutoedu.lmsadmin.web;

import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.service.AuthorService;
import com.tutoedu.lmsadmin.service.BookService;
import com.tutoedu.lmsadmin.web.dto.BookSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/book/api")
@RequiredArgsConstructor
public class BookApiController {

    private final AuthorService authorService;

    private final BookService bookService;

    @ResponseBody
    @PostMapping("/save")
    public Long save(@RequestBody BookSaveRequestDto requestDto){

        //작가 정보 set
        Long authorId = requestDto.getAuthorId();

        log.debug("save@authorId = {}", authorId);

        Author author = authorService.findById(authorId);

        log.debug("save@author = {}", author);

        requestDto.setAuthor(author);

        Long result = bookService.save(requestDto);

        return result;
    }
}
