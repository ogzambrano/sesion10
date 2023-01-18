/*
package com.example.apirestlaptop.controller;

import org.junit.jupiter.api.BeforeAll;
import com.example.apirestlaptop.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json = """
                {
                    "market": "HP",
                    "model": "Lenovo",
                    "releaseDate": "2000-02-07",
                    "online": true
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);

        HttpHeaders headers2 = new HttpHeaders();
        headers2.setContentType(MediaType.APPLICATION_JSON);
        headers2.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json2 = """
                {
                    "market": "HP",
                    "model": "Lenovo",
                    "releaseDate": "2000-02-07",
                    "online": true
                }
                """;
        HttpEntity<String> request2 = new HttpEntity<>(json2, headers2);
        testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request2,Laptop.class);
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json = """
                {
                    "market": "IMB",
                    "model": "IMBIOS",
                    "releaseDate": "2022-07-01",
                    "online": true
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);

        Laptop result = response.getBody();
        assertEquals("IMB",result.getMarket());


    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops",Laptop[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        System.out.println(response.getBody().length);
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/laptops/1",Laptop.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        System.out.println(response.getBody().getMarket());
    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json = """
                {
                    "id": 1,
                    "market": "MAC",
                    "model": "MACIOS",
                    "releaseDate": "2000-02-07",
                    "online": true
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops",HttpMethod.PUT,request,Laptop.class);

        Laptop result = response.getBody();
        assertEquals("MAC",result.getMarket());

    }

    @Test
    void deleteOneById() {
        testRestTemplate.delete("/api/laptops/1");
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops",Laptop[].class);
        assertEquals(1,response.getBody().length);
    }

    @Test
    void deleteAll() {
        testRestTemplate.delete("/api/laptops");
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops",Laptop[].class);
        assertEquals(0,response.getBody().length);
    }
}*/