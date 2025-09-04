
package com.internshipproject.www.service;

	import java.util.List;

import com.internshipproject.www.Dto.BookDto;
import com.internshipproject.www.model.Book;

	public interface BookService {
	    BookDto createBook(BookDto bookDto);
	    BookDto getBookById(Long id);
	    List<BookDto> getAllBooks();
	    BookDto updateBook(Long id, BookDto bookDto);
	    void deleteBook(Long id);
	    BookDto mapToDto(Book book);
	}

