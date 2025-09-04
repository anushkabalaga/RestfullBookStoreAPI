package com.internshipproject.www.repository;

	import org.springframework.data.jpa.repository.JpaRepository;

import com.internshipproject.www.model.Author;

	public interface AuthorRepository extends JpaRepository<Author, Long> {
		
		
	}
