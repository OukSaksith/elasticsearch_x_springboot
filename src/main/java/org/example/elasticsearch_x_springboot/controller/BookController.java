package org.example.elasticsearch_x_springboot.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.example.elasticsearch_x_springboot.metadata.PublicationYear;
import org.example.elasticsearch_x_springboot.model.Book;
import org.example.elasticsearch_x_springboot.service.BookService;
import org.example.elasticsearch_x_springboot.service.exception.BookNotFoundException;
import org.example.elasticsearch_x_springboot.service.exception.DuplicateIsbnException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public Book createBook(@Valid @RequestBody BookDto book) throws DuplicateIsbnException {
        return bookService.create(BookDto.transform(book));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) throws BookNotFoundException {
        return bookService.getByIsbn(isbn).orElseThrow(() -> new BookNotFoundException("The given isbn is invalid"));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/query")
    public List<Book> getBooksByAuthorAndTitle(@RequestParam(value = "title") String title, @RequestParam(value = "author") String author) {
        return bookService.findByTitleAndAuthor(title, author);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody BookDto book) throws BookNotFoundException {
        return bookService.update(id, BookDto.transform(book));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteById(id);
    }

//    @Data
    public static class BookDto {

        @NotBlank
        private String title;

        @Positive
        @PublicationYear
        private Integer publicationYear;

        @NotBlank
        private String authorName;

        @NotBlank
        private String issbn;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getPublicationYear() {
            return publicationYear;
        }

        public void setPublicationYear(Integer publicationYear) {
            this.publicationYear = publicationYear;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getIssbn() {
            return issbn;
        }

        public void setIssbn(String isbn) {
            this.issbn = isbn;
        }
    static Book transform(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setPublicationYear(bookDto.getPublicationYear());
        book.setAuthorName(bookDto.getAuthorName());
        book.setIssbn(bookDto.getIssbn());
        return book;
    }
    }
}
