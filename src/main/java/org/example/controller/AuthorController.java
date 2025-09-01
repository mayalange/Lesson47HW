package org.example.controller;

import org.example.model.Author;
import org.example.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable UUID id) {
        Author author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }
}