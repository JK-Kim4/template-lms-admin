package com.tutoedu.lmsadmin.domain.book;

import com.tutoedu.lmsadmin.domain.BaseTimeEntity;
import com.tutoedu.lmsadmin.domain.author.Author;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private String title;
    private String content;

    @Builder
    public Book(String title, Author author, String content){
        this.title = title;
        this.author = author;
        this.content = content;

    }

}
