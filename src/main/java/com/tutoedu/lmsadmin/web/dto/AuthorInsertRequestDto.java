package com.tutoedu.lmsadmin.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthorInsertRequestDto {

    private String name1;
    private String name2;
    private String name3;
    private String description;
    private String authImgUrl;

    @Builder
    public AuthorInsertRequestDto(String name1, String name2, String name3, String description, String authImgUrl){
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.description = description;
        this.authImgUrl = authImgUrl;
    }
}
