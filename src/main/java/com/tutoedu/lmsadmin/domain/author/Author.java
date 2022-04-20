package com.tutoedu.lmsadmin.domain.author;

import com.tutoedu.lmsadmin.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
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
    private String content;

    @Column
    private String imgUrl;

    @Builder
    public Author(String name1, String name2, String name3, String content, String imgUrl){
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.content = content;
        this.imgUrl = imgUrl;
    }


/*    private int authSeq;
    private String name1;
    private String name2;
    private String name3;
    private String description;
    private String authImgUrl;*/

}
