package com.tutoedu.lmsadmin.service;

import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.domain.author.AuthorRepository;
import com.tutoedu.lmsadmin.web.dto.AuthorSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public Long save(AuthorSaveRequestDto requestDto){
        return authorRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<Author> findAll(){

        log.debug("findAll@AuthorService : {}", authorRepository.findAll().toArray());

        return authorRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Author findById(Long authorId) {

        Author entity = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("해당 저자가 존재하지 않습니다. id = " + authorId));

        return entity;
    }
}
