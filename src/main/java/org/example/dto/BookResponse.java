package org.example.dto;

import java.util.UUID;

public class BookResponse {
    private UUID id;
    private String title;
    private String isbn;
    private UUID authorId;
    private String authorName;
    private Boolean available;

    public BookResponse() {}

    public BookResponse(UUID id, String title, String isbn, UUID authorId, String authorName, Boolean available) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
        this.authorName = authorName;
        this.available = available;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public UUID getAuthorId() { return authorId; }
    public void setAuthorId(UUID authorId) { this.authorId = authorId; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}