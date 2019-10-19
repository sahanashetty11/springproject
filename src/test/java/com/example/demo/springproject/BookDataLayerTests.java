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
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class BookDataLayerTests {
    @Autowired
    private BooksREpo booksREpo;


    @Test
    public void test(){
        List<Books> b= (List<Books>) booksREpo.findAll();
        Assert.assertNotNull(b);
    }

    @Test
    public void addTest(){
        Books books1=new Books();
        books1.setId(1);
        books1.setTitle("yaman");
        booksREpo.save(books1);
        Iterable<Books> b=booksREpo.findAll();
        List<Books> bb= (List<Books>) b;
        Assert.assertEquals(books1.getTitle(),bb.get(0).getTitle());
    }

    @Test
    public void findTest(){
        Books books1=new Books();
        books1.setId(1);
        books1.setTitle("yaman");
        booksREpo.save(books1);
        Books b=booksREpo.findById(1).get();
        Assert.assertEquals(books1.getTitle(),b.getTitle());

    }

    @Test
    public void deleteTest(){
        Books books1=new Books();
        books1.setId(1);
        books1.setTitle("yaman");
        booksREpo.save(books1);
        booksREpo.deleteById(1);
        Assert.assertEquals(0,booksREpo.count());
    }
}
