package com.example.demo.springproject.controller;

import com.example.demo.springproject.entity.Books;
import com.example.demo.springproject.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping(method = RequestMethod.GET, value = "/show")
    public List<Books> add(){
        return booksService.show();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String add(@RequestBody Books books){
        return booksService.add(books);
    }

    @RequestMapping(method = RequestMethod.GET,value="/title/{id}")
    public String title(@PathVariable int id)
    {
        return  booksService.title(id);
    }

    @RequestMapping(method = RequestMethod.POST,value="/delete/{id}")
    public String deletebyid(@PathVariable int id)
    {
        return  booksService.deletebyid(id);
    }

    @RequestMapping(method = RequestMethod.GET,value="/find/{id}")
    public Books findbyid(@PathVariable int id)
    {
        return  booksService.findbyid(id);
    }
}
