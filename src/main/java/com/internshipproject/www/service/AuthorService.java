package com.internshipproject.www.service;

import java.util.List;

import com.internshipproject.www.Dto.AuthorDto;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);
    
    AuthorDto getAuthorById(Long id);
    
    List<AuthorDto> getAllAuthors();
    
    AuthorDto updateAuthor(Long id, AuthorDto authorDto);
    
    
    void deleteAuthor(Long id);

	AuthorDto getAuthorWithBook(Long id);
}