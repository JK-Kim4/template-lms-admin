package com.tutoedu.lmsadmin.mappers;

import com.tutoedu.lmsadmin.web.dto.AuthorInsertRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorMapper {
    int save(AuthorInsertRequestDto requestDto);
}
