package com.tutoedu.lmsadmin.service;

import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.domain.author.AuthorRepository;
import com.tutoedu.lmsadmin.web.dto.AuthorSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return authorRepository.findAll();
    }


}
