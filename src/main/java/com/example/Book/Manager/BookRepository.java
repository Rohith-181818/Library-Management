package com.example.Book.Manager;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository {

    ArrayList<Book> getBooks();
    Book getBookById(int bookId);
    Book addBook(Book book);
    Book updateBook(Book book,int bookId);
    void deleteBook(int bookId);
}
