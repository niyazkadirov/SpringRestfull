package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class,  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorControllerTest {

    private static final String RESOURCE_LOCATION_PATTERN = "http://localhost:8080/author/[0-9]+";



    @InjectMocks
    AuthorController controller;

    @Autowired
    WebApplicationContext context;

    @Autowired
    private TestRestTemplate restTemplate;

    private MockMvc mvc;


    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    private String getRootUrl() {
        return "http://localhost:8080";
    }


    @Test
    void getAuthor() {
        Author author = restTemplate.getForObject(getRootUrl() + "/author/1", Author.class);
        System.out.println(author.getFullName());
        Assert.assertNotNull(author);
    }

    @Test
    void getAllAuthor() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/author",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    @Test
    void createAuthor() {
        Set<Book> books = new HashSet<>();
        Author author = new Author();
        Mockito.when(author.setBooks(books)).thenReturn();
        author.setDob(LocalDateTime.now());
        author.setFullName("full name");

        ResponseEntity<Author> postResponse = restTemplate.postForEntity(getRootUrl() + "/author", author, Author.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    void updateAuthor() {
    }

    @Test
    void deleteAuthor() {
    }
}