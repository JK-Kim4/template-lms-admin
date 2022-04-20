package com.tutoedu.lmsadmin.service;

import com.tutoedu.lmsadmin.mappers.AuthorMapper;
import com.tutoedu.lmsadmin.web.dto.AuthorInsertRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorMapper authorMapper;

    public int insert(AuthorInsertRequestDto requestDto) {
        return authorMapper.save(requestDto);
    }
}
