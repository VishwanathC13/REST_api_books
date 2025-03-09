package com.devneo.books;

import com.devneo.books.domain.Book;
import com.devneo.books.domain.BookEntity;

public final class TestData {
    private TestData(){

    }

    public static Book testBook(){
        return Book.builder()
        .isbn("02345678")
        .author("Virginia Woolf")
        .title("The Waves")
        .build();

    }

    public static BookEntity tesBookEntity(){
        return BookEntity.builder()
        .isbn("02345678")
        .author("Virginia Woolf")
        .title("The Waves")
        .build();
    }
}
