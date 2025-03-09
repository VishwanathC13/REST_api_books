package com.devneo.books.services;

import java.util.List;
import java.util.Optional;

import com.devneo.books.domain.Book;

public interface BookService {
    
        boolean isBookExists(Book book);

        Book save( Book book);

        Optional<Book> findByID(String isbn);

        List<Book> listBooks();

        void deleteBookById(String isbn);
}
