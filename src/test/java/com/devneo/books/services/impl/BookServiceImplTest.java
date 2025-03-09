package com.devneo.books.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.devneo.books.TestData.testBook;
import static com.devneo.books.TestData.tesBookEntity;
import com.devneo.books.domain.Book;
import com.devneo.books.domain.BookEntity;
import com.devneo.books.repositories.BookRepository;


@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {
    
    @Mock
    private BookRepository bookRepository;
    
    @InjectMocks
    private BookServiceImpl underTest;

    @Test
    public void testThatBookIsSaved(){
        final Book book = testBook();


        final BookEntity bookEntity = tesBookEntity();

        when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);

        final Book result = underTest.save(book);

        assertEquals(book, result);
    }
    @Test
    public void testThatFindByIDReturnsEmptyWhenNoBook(){
        final String isbn = "12345678";

        when(bookRepository.findById(eq(isbn))).thenReturn(Optional.empty());
        final Optional<Book> result = underTest.findByID(isbn);
        assertEquals(Optional.empty(), result);
    }
    @Test
    public void testThatFindByIDReturnsBookWhenExists(){
        final Book book = testBook();
        final BookEntity bookEntity = tesBookEntity();
        when(bookRepository.findById(eq(book.getIsbn()))).thenReturn(Optional.of(bookEntity));
        final Optional<Book> result = underTest.findByID(book.getIsbn());
        assertEquals(Optional.of(book), result);
}
    @Test
    public void testThatListAllReturnsEmptyWhenNoBooksexists(){
        when (bookRepository.findAll()).thenReturn(new ArrayList<BookEntity>());
        final List<Book> result = underTest.listBooks();
        assertEquals(0, result.size());
    }

    @Test
    public void testThatListAllReturnsBooksWhenExist(){
        final Book book = testBook();
        final BookEntity bookEntity = tesBookEntity();
        when(bookRepository.findAll()).thenReturn(List.of(bookEntity));
        final List<Book> result = underTest.listBooks();
        assertEquals(List.of(book), result);
    }

    @Test
    public void testBooksExistsReturnsFalseWhenBookDoesntExists(){
        when(bookRepository.existsById(any())).thenReturn(false);
        final boolean result = underTest.isBookExists(testBook());
        assertEquals(false, result);
}
    @Test
    public void testBooksExistsReturnsTrueWhenBooksExists(){
        when(bookRepository.existsById(any())).thenReturn(true);
        final boolean result = underTest.isBookExists(testBook());
        assertEquals(true, result);
}
    @Test
    public void testDeleteBookDeletesBook(){
        final String isbn = "12345678";
        underTest.deleteBookById(isbn);
        verify(bookRepository, times(1)).deleteById(eq(isbn));
    }
}