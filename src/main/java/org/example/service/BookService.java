package org.example.service;

import org.example.dto.BookResponse;
import org.example.model.Book;
import org.example.model.Author;
import org.example.repository.BookRepository;
import org.example.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public BookResponse getBookById(UUID id) {
        return bookRepository.findById(id)
                .map(this::convertToResponse)
                .orElse(null);
    }

    public BookResponse createBook(String title, String isbn, UUID authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        if (bookRepository.existsByIsbn(isbn)) {
            throw new RuntimeException("Book with ISBN " + isbn + " already exists");
        }

        Book book = new Book(title, isbn, author);
        Book savedBook = bookRepository.save(book);
        return convertToResponse(savedBook);
    }

    private BookResponse convertToResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getAuthor().getId(),
                book.getAuthor().getName(),
                book.getAvailable()
        );
    }
}