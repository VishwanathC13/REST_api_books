package com.devneo.books.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devneo.books.domain.Book;
import com.devneo.books.services.BookService;

@RestController
public class BookController {
    
    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService){
        this .bookService = bookService;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<Book> createUpdateBook(@PathVariable final String isbn,@RequestBody final Book book){
        book.setIsbn(isbn);
        final boolean exists = bookService.isBookExists(book);
        final Book savedBook = bookService.save(book);
        if(exists){
            return new ResponseEntity<Book>(savedBook,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);
        }
        
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<Book> retrieveBook(@PathVariable final String isbn){
        final Optional<Book> foundBook = bookService.findByID(isbn);
        return foundBook.map(book -> new ResponseEntity<Book>(book,HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<Book>(HttpStatus.NOT_FOUND));
    }
    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> listBooks(){
        return new ResponseEntity<List<Book>>(bookService.listBooks(),HttpStatus.OK);
    }
    @SuppressWarnings("rawtypes")
    @DeleteMapping(path = "/books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable final String isbn){
        bookService.deleteBookById(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
