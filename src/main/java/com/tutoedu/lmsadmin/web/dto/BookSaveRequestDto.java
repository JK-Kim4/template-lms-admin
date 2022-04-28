package com.tutoedu.lmsadmin.web.dto;

import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.domain.book.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookSaveRequestDto {

    private Author author;
    private String title;
    private String content;

    @Builder
    public BookSaveRequestDto(Author author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Book toEntity(){
        return Book.builder()
                        .title(title)
                        .author(author)
                        .content(content)
                        .build();
    }
}
