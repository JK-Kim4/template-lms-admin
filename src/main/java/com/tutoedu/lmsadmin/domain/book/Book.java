package com.tutoedu.lmsadmin.domain.book;

import com.tutoedu.lmsadmin.domain.BaseTimeEntity;
import com.tutoedu.lmsadmin.domain.author.Author;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;
    private String content;

    @Builder
    public Book(String title, Author author, String content){
        this.title = title;
        this.author = author;
        this.content = content;

    }

}
