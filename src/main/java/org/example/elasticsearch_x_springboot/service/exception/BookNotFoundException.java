package org.example.elasticsearch_x_springboot.service.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }

}
