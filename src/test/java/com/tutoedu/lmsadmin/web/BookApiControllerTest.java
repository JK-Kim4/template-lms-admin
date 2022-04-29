package com.tutoedu.lmsadmin.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.domain.author.AuthorRepository;
import com.tutoedu.lmsadmin.domain.book.Book;
import com.tutoedu.lmsadmin.domain.book.BookRepository;
import com.tutoedu.lmsadmin.web.dto.AuthorSaveRequestDto;
import com.tutoedu.lmsadmin.web.dto.BookSaveRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    private MockMvc mvc;

    @BeforeEach
    public void beforeEach() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    @Transactional
    public void book_save_test() throws Exception {

        String name1 = "test name1";
        String name2 = "test name2";
        String name3 = "test name3";

        String title = "test title";
        String content = "test content";

        //given
        AuthorSaveRequestDto authorRequest = AuthorSaveRequestDto.builder()
                .name1(name1)
                .name2(name2)
                .name3(name3)
                .build();

        String url = "http://localhost:" + port + "/author/api/save";

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(authorRequest)))
                .andExpect(status().isOk());

        List<Author> authorList = authorRepository.findAll();
        Author author = authorList.get(0);
        Long authorId = author.getId();

        System.out.println("given author : " + author + ", given id : " + authorId);

        url = "http://localhost:" + port + "/book/api/save";

        BookSaveRequestDto bookRequest = BookSaveRequestDto.builder()
                .authorId(authorId)
                .title(title)
                .content(content)
                .build();

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(bookRequest)))
                .andExpect(status().isOk());

        //then
        List<Book> bookList = bookRepository.findAll();

        assertThat(bookList.get(0).getContent().equals(content));
        assertThat(bookList.get(0).getTitle().equals(title));
        assertThat(bookList.get(0).getAuthor().getId().equals(authorId));

    }


}
