package com.tutoedu.lmsadmin.service;

import com.tutoedu.lmsadmin.mappers.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorMapper authorMapper;

}
