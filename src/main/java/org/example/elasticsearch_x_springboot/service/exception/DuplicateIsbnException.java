package org.example.elasticsearch_x_springboot.service.exception;

public class DuplicateIsbnException extends Exception {
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
