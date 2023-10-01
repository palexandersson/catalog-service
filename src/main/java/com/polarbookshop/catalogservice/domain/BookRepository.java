package com.polarbookshop.catalogservice.domain;

import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BookRepository {
    public Iterable<Book> findAll();
    public Optional<Book> findByIsbn(String isbn);
    public boolean existByIsbn(String isbn);
    public void deleteByIsbn(String isbn);
    public Book save(Book bookToUpdate);
}
