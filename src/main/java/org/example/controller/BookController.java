package org.example.controller;

import org.example.dto.BookRequest;
import org.example.dto.BookResponse;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable UUID id) {
        BookResponse book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest) {
        try {
            BookResponse book = bookService.createBook(
                    bookRequest.getTitle(),
                    bookRequest.getIsbn(),
                    bookRequest.getAuthorId()
            );
            return ResponseEntity.ok(book);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}