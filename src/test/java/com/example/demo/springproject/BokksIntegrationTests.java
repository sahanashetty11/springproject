package com.example.demo.springproject;

import com.example.demo.springproject.entity.Books;
import com.jayway.jsonassert.JsonAssert;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import netscape.javascript.JSObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BokksIntegrationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    HttpHeaders httpHeaders=new HttpHeaders();

    @Test
    public void showTest(){
        String response=this.testRestTemplate.getForObject("/show", String.class);
        DocumentContext context=JsonPath.parse(response);
        int length=context.read("$.length()");
        assertThat(length).isEqualTo(2);
    }

    @Test
    public void addTest(){
        Books books1=new Books();
        books1.setId(1);
        books1.setTitle("yaman");
        HttpEntity<Books> entity = new HttpEntity<Books>(books1,httpHeaders);
        ResponseEntity<String> response= this.testRestTemplate.exchange(createURLWithPort("/add"), HttpMethod.POST,entity,String.class);
        Assert.assertEquals("Added successfully",response.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:8080"+uri;
    }

    @Test
    public void findTest(){
        HttpEntity<String> entity = new HttpEntity<String>(null,httpHeaders);
        ResponseEntity<String> response= this.testRestTemplate.exchange(createURLWithPort("/find/1"), HttpMethod.GET,entity,String.class);
        String expected="{\"id\":1,\"title\":\"yaman\"}";
        Assert.assertEquals(expected,response.getBody());
    }

    @Test
    public void deleteTest(){
        HttpEntity<String> entity = new HttpEntity<String>(null,httpHeaders);
        ResponseEntity<String> response= this.testRestTemplate.exchange(createURLWithPort("/delete/2"), HttpMethod.POST,entity,String.class);
        Assert.assertEquals("200 OK",response.getStatusCode().toString());
    }

    @Test
    public void findtitle(){
        HttpEntity<String> entity = new HttpEntity<String>(null,httpHeaders);
        ResponseEntity<String> response= this.testRestTemplate.exchange(createURLWithPort("/title/1"), HttpMethod.GET,entity,String.class);
        Assert.assertEquals("yaman",response.getBody());
    }

    @Test
    public void khali(){
        //Dummy test method
    }

    @Test
    public void khalisecond() {
        //Dummy test method second branch
    }
}