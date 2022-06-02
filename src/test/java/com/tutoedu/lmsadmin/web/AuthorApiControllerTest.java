package com.tutoedu.lmsadmin.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutoedu.lmsadmin.domain.author.Author;
import com.tutoedu.lmsadmin.domain.author.AuthorRepository;
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

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AuthorApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private AuthorRepository authorRepository;

    private MockMvc mvc;

    @BeforeEach
    public void beforeEach() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

/*    @AfterEach
    public void tearDown() throws Exception{
        authorRepository.deleteAll();
    }*/

    @Test
    public void author_save_test() throws Exception {

        String name1 = "test1";
        String name2 = "test2";
        String name3 = "test3";
        String description = "test description";
        String imgUrl = "test url";

        //BaseTimeEntity 검증 추가
        LocalDateTime now = LocalDateTime.now();

        //given
        AuthorSaveRequestDto request = AuthorSaveRequestDto.builder()
                .name1(name1)
                .name2(name2)
                .name3(name3)
                .description(description)
                .imgUrl(imgUrl)
                .build();

        String url = "http://localhost:" + port + "/author/api/save";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk());
        //then
        List<Author> all = authorRepository.findAll();

        assertThat(all.get(0).getName1()).isEqualTo(name1);
        assertThat(all.get(0).getDescription()).isEqualTo(description);
        assertThat(all.get(0).getCreatedDate()).isAfter(now);
        assertThat(all.get(0).getModifiedDate()).isAfter(now);

    }

}
