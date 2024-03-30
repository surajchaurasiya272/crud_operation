package com.book_apis.bookdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.book_apis.bookdemo.entities.Book;
// import java.util.List;


public interface BookRepository  extends CrudRepository<Book,Integer>{
    public Book findById(int id);
}
