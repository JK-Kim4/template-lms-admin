package com.tutoedu.lmsadmin.domain.author;

import com.tutoedu.lmsadmin.domain.BaseTimeEntity;
import com.tutoedu.lmsadmin.domain.book.Book;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name1;

    @Column(length = 50, nullable = true)
    private String name2;

    @Column(length = 150, nullable = true)
    private String name3;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column
    private String imgUrl;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();


    @Builder
    public Author(String name1, String name2, String name3, String description, String imgUrl){
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.description = description;
        this.imgUrl = imgUrl;
    }

}
