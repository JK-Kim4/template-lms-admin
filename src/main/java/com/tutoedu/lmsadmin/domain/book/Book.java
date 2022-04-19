package com.tutoedu.lmsadmin.domain.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int bkSeq;
    private String title;
    private String author;
    private String content;

}
