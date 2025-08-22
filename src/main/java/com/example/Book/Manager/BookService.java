package com.example.Book.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements BookRepository {
    @Autowired
    private BookJpaRepository bookRepository;

    @Override
    public ArrayList<Book> getBooks(){
        List<Book> books = bookRepository.findAll();
        return new ArrayList<>(books);
    }
    @Cacheable("books")
    @Override
    public Book getBookById(int bookId){
        try {
            Book book = bookRepository.findById(bookId).get();
            return book;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Book addBook(Book book){
        bookRepository.save(book);
        return book;
    }

    @CachePut("books")
    @Override
    public Book updateBook(Book book,int bookId){
        try {
            Book newBook = bookRepository.findById(bookId).get();
            if (book.getName() != null) {
                newBook.setName(book.getName());
            }
            if (book.getAuthor() != null) {
                newBook.setAuthor(book.getName());
            }
            bookRepository.save(newBook);
            return newBook;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @CacheEvict("books")
    @Override
    public void deleteBook(int bookId){
        bookRepository.deleteById(bookId);
    }
}
