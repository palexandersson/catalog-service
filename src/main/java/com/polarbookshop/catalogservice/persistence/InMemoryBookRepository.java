package com.polarbookshop.catalogservice.persistence;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> books = new ConcurrentHashMap<>();
    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existByIsbn(isbn) ? Optional.of(books.get(isbn))
        : Optional.empty();
    }

    @Override
    public boolean existByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }

    @Override
    public Book save(Book book) {
        books.put(book.isbn(), book);
        return book;
    }
}
