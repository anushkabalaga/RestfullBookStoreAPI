package com.internshipproject.www.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internshipproject.www.Dto.AuthorDto;
import com.internshipproject.www.Dto.BookDto;
import com.internshipproject.www.exception.ResourceNotFoundException;
import com.internshipproject.www.model.Author;
import com.internshipproject.www.repository.AuthorRepository;
import com.internshipproject.www.repository.BookRepository;
import com.internshipproject.www.service.AuthorService;
import com.internshipproject.www.service.BookService;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookService bookService;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             BookRepository bookRepository,
                             BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setNationality(authorDto.getNationality());
        author.setEmail(authorDto.getEmail());

        Author savedAuthor = authorRepository.save(author);
        return mapToDto(savedAuthor, false);
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));
        return mapToDto(author, false);
    }

    @Override
    @Transactional(readOnly = true)
    public AuthorDto getAuthorWithBook(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));
        return mapToDto(author, true);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> mapToDto(author, false))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto updateAuthor(Long id, AuthorDto authorDto) {
        Author updatedAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));

        updatedAuthor.setName(authorDto.getName());
        updatedAuthor.setNationality(authorDto.getNationality());
        updatedAuthor.setEmail(authorDto.getEmail());

        return mapToDto(authorRepository.save(updatedAuthor), false);
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found with id " + id);
        }
        authorRepository.deleteById(id);
    }

    // Private helper to map Author to AuthorDto
    private AuthorDto mapToDto(Author author, boolean includeBooks) {
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setNationality(author.getNationality());
        dto.setEmail(author.getEmail());

        if (includeBooks && author.getBooks() != null) {
            List<BookDto> books = author.getBooks().stream()
                    .map(bookService::mapToDto)  // Ensure BookService has mapToDto(Book book)
                    .collect(Collectors.toList());
            dto.setBooks(books);
        }
        return dto;
    }
}

