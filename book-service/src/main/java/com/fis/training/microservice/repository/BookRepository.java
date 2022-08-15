package com.fis.training.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.training.microservice.bookservice.bean.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	
	
}
