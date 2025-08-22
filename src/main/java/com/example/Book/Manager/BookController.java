package com.example.Book.Manager;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@Slf4j
@RestController
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @GetMapping("/books")

    public ArrayList<Book> getBooks(){
        log.info("Information...!");
        return bookService.getBooks();
    }

    @GetMapping("/book/{bookId}")

    public Book getBookById(@PathVariable("bookId") int bookId){
        log.warn("Warning...!?");
        return bookService.getBookById(bookId);
    }

    @PostMapping("/book")

    public Book addBook(@RequestBody Book book){
        log.debug("Debugging...!");
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
