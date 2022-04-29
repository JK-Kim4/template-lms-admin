package com.tutoedu.lmsadmin.web.dto;

import com.tutoedu.lmsadmin.domain.author.Author;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthorSaveRequestDto {

    private String name1;
    private String name2;
    private String name3;
    private String description;
    private String imgUrl;

    @Builder
    public AuthorSaveRequestDto(String name1, String name2, String name3, String description, String imgUrl){
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public Author toEntity(){
        return Author.builder()
                .name1(name1)
                .name2(name2)
                .name3(name3)
                .description(description)
                .imgUrl(imgUrl)
                .build();
    }

}
