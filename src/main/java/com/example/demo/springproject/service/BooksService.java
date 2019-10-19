package com.example.demo.springproject.service;

import com.example.demo.springproject.entity.Books;
import com.example.demo.springproject.repo.BooksREpo;
import com.sun.deploy.security.SelectableSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BooksREpo booksREpo;

    public String add(Books books)
    {
        if(books!=null)
        {
            if(books.getTitle().length()>=6) {
                return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).toString();
            }
            booksREpo.save(books);
            return "Added successfully";
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).toString();


    }

    public List<Books> show() {
        List<Books> al = new ArrayList<>();
        for (Books b : booksREpo.findAll()) {
            al.add(b);

        }
        return al;
    }

    public String title(int id) {
        for(Books b:booksREpo.findAll())
        {
            if(b.getId()==id)
            {
                return b.getTitle();

            }
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).toString();
    }

    public Books findbyid(int id){
        return booksREpo.findById(id).get();
    }

    public String deletebyid(int id){
        if(id!=0)
        {
            booksREpo.deleteById(id);
            return "Deleted successfully";

        }
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST).toString();
    }

    }



