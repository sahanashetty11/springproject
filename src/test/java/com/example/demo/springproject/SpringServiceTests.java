package com.example.demo.springproject;

import com.example.demo.springproject.entity.Books;
import com.example.demo.springproject.repo.BooksREpo;
import com.example.demo.springproject.service.BooksService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringServiceTests {
    @InjectMocks
    private BooksService booksService;

    @Mock
    private BooksREpo booksREpo;

    @Test
    public void booksserviceTest(){
        Books books1=new Books();
        books1.setId(1);
        books1.setTitle("yaman");
        Books books2=new Books();
        books2.setId(2);
        books2.setTitle("sahana");
        Mockito.when(booksREpo.findAll()).thenReturn(Arrays.asList(books1,books2));
        List<Books> b= booksService.show();
        assertThat(Arrays.asList(books1,books2)).isEqualTo(b);
    }

    @Test
    public void addServiceTest(){
        Books books1=new Books();
        books1.setId(1);
        books1.setTitle("yaman");
        Mockito.when(booksREpo.save(books1)).thenReturn(books1);
        String s= booksService.add(books1);
        Assert.assertEquals("Added successfully",s);
    }

    @Test
    public void findServiceTest(){
        Books books1=new Books();
        books1.setId(1);
        books1.setTitle("yaman");
        Mockito.when(booksREpo.findById(books1.getId())).thenReturn(Optional.of(books1));
        Books s= booksService.findbyid(1);
        Assert.assertEquals(books1,s);
    }

    @Test
    public void deleteServiceTest(){
        Books books1=new Books();
        books1.setId(1);
        books1.setTitle("yaman");
        String s= booksService.deletebyid(books1.getId());
        Assert.assertEquals("Deleted successfully",s);
    }
}
