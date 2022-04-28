package com.tutoedu.lmsadmin.service;

import com.tutoedu.lmsadmin.domain.book.Book;
import com.tutoedu.lmsadmin.domain.book.BookRepository;
import com.tutoedu.lmsadmin.web.dto.BookSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Long save(BookSaveRequestDto requestDto){

        return bookRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public List<Book> findAll(){

        log.debug("findAll@bookRepository : {}", bookRepository.findAll().toArray());

        return bookRepository.findAll();
    }
}
