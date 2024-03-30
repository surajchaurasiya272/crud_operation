package com.book_apis.bookdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book_apis.bookdemo.Service.BookService;
import com.book_apis.bookdemo.entities.Book;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBookData();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getById(id);
    }

    @PostMapping
    public Book creteBookById(@RequestBody Book book) {
        return bookService.getAddBook(book);
    }
    
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable int id) {
            return bookService.getUpdateBook(book,id);
   }

   @DeleteMapping("/{id}")
   public void deleteBookById(@PathVariable int id){
       this.bookService.deleteBook(id);
   }

}
