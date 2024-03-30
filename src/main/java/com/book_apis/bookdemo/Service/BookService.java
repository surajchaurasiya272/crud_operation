package com.book_apis.bookdemo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book_apis.bookdemo.dao.BookRepository;

// import org.springframework.stereotype.Service;

import com.book_apis.bookdemo.entities.Book;

// @Service
@Component
public class BookService {
  @Autowired
  private BookRepository bookRepository;
  // public static List<Book> list= new ArrayList<>();
  // static{
  // list.add(new Book(12,"suraj","prog"));
  // list.add(new Book(1,"amit","dancer"));
  // list.add(new Book(192,"rampal","sing"));
  // }

  public List<Book> getBookData() {
    List<Book> list = (List<Book>) this.bookRepository.findAll();
    return list;
  }

  public Book getById(int id) {
    Book book = null;
    try {
      book = this.bookRepository.findById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return book;
  }

  public Book getAddBook(Book book) {
    Book result = bookRepository.save(book);
    // list.add(book);
    return result;
  }

  public Book getUpdateBook(Book book, int id) {
    // Book book = this.bookRepository.findById(id);
    book.setId(id);
    Book result = this.bookRepository.save(book);
    // System.out.println("suraj"+book);
    return result;
  }

  public void deleteBook(int id){
     this.bookRepository.deleteById(id);
    // return result;
  }

}
