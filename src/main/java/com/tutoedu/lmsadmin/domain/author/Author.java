package com.tutoedu.lmsadmin.domain.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private int authSeq;
    private String name1;
    private String name2;
    private String name3;
    private String description;
    private String authImgUrl;

}
