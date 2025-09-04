package com.internshipproject.www.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.internshipproject.www.Dto.BookDto;
import com.internshipproject.www.exception.ResourceNotFoundException;
import com.internshipproject.www.model.Author;
import com.internshipproject.www.model.Book;
import com.internshipproject.www.repository.AuthorRepository;
import com.internshipproject.www.repository.BookRepository;
import com.internshipproject.www.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Author not found with id " + bookDto.getAuthorId()));

        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setPrice(bookDto.getPrice());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setAuthor(author);

        Book saved = bookRepository.save(book);
        return mapToDto(saved);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return mapToDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));

        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Author not found with id " + bookDto.getAuthorId()));

        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setPrice(bookDto.getPrice());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setAuthor(author);

        Book updated = bookRepository.save(book);
        return mapToDto(updated);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto mapToDto(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setIsbn(book.getIsbn());
        dto.setPrice(book.getPrice());
        dto.setPublishedDate(book.getPublishedDate());
        dto.setAuthorId(book.getAuthor().getId());
        return dto;
    }
}
