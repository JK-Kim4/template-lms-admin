package com.tutoedu.lmsadmin.web.dto;

import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.domain.book.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookSaveRequestDto {

    private Long authorId;
    private String title;
    private String content;

    private Author author;

    @Builder
    public BookSaveRequestDto(Long authorId, String title, String content){
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public Book toEntity(){
        return Book.builder()
                        .title(title)
                        .author(author)
                        .content(content)
                        .build();
    }
}
