package com.example.demo.springproject;

import com.example.demo.springproject.entity.Books;
import com.example.demo.springproject.repo.BooksREpo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.activation.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BooksRepoTest {

    @Autowired
    private BooksREpo booksREpo;

    @Test
    public void test(){
        List<Books> b= (List<Books>) booksREpo.findAll();
        Assert.assertNotNull(b);
    }

}
