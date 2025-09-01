package org.example.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(nullable = false)
    private Boolean available = true;

    public Book() {}

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.available = true;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}