package com.tutoedu.lmsadmin.web.dto;

import com.tutoedu.lmsadmin.domain.author.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthorResponseDto {

    private Long id;
    private String name1;
    private String name2;
    private String name3;
    private String description;
    private String imgUrl;


    public AuthorResponseDto(Author entity){
        this.id = entity.getId();
        this.name1 = entity.getName1();
        this.name2 = entity.getName2();
        this.name3 = entity.getName3();
        this.description = entity.getDescription();
        this.imgUrl = entity.getImgUrl();
    }

}
