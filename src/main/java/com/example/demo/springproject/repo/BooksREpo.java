package com.example.demo.springproject.repo;

import com.example.demo.springproject.entity.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksREpo extends CrudRepository<Books,Integer> {

}
