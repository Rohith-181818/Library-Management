package com.example.Book.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")

    public ArrayList<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/book/{bookId}")

    public Book getBookById(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping("/book")

    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/book/{bookId}")

    public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId){
        return bookService.updateBook(book,bookId);
    }

    @DeleteMapping("/book/{bookId}")

    public void deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
    }
}
