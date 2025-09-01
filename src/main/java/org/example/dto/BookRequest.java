package org.example.dto;

import java.util.UUID;

public class BookRequest {
    private String title;
    private String isbn;
    private UUID authorId;

    public BookRequest() {}

    public BookRequest(String title, String isbn, UUID authorId) {
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public UUID getAuthorId() { return authorId; }
    public void setAuthorId(UUID authorId) { this.authorId = authorId; }
}