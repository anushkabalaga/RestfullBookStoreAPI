package com.internshipproject.www.Dto;

import java.time.LocalDate;

import lombok.Data;

	@Data
	public class BookDto {
	    private Long id;
	    private String title;
	    private String isbn;
	    private Double price;
	    private LocalDate publishedDate;
	    private Long authorId;  // we pass authorId instead of whole Author object
	}

