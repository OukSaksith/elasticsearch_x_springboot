package org.example.elasticsearch_x_springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "books")
//@Data
public class Book {
    @Id
    private String id;

    private String title;

    private int publicationYear;

    private String authorName;

    private String issbn;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
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
}
