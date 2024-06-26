package org.example.elasticsearch_x_springboot.service;

import org.example.elasticsearch_x_springboot.model.Book;
import org.example.elasticsearch_x_springboot.service.exception.BookNotFoundException;
import org.example.elasticsearch_x_springboot.service.exception.DuplicateIsbnException;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> getByIsbn(String isbn);

    List<Book> getAll();

    List<Book> findByAuthor(String authorName);

    List<Book> findByTitleAndAuthor(String title, String author);

    Book create(Book book) throws DuplicateIsbnException;

    void deleteById(String id);

    Book update(String id, Book book) throws BookNotFoundException;
}
