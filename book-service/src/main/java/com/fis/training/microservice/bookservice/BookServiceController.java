package com.fis.training.microservice.bookservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fis.training.microservice.bookservice.bean.Book;
import com.fis.training.microservice.repository.BookRepository;

@RestController
public class BookServiceController {
	
	@Autowired
	private  BookRepository bookRepository;
	

	@GetMapping("/books")
	public Book retrieveBooks() {
		return new Book("a", "b", "c", 0, 0);
		
	}
	
	@GetMapping("/show")
	public List<Book> show() {
		return bookRepository.findAll();
		
	}
	
	@GetMapping("/book/{id}")
	public Optional<Book> getBook(@PathVariable String id) {
		return bookRepository.findById(id);
		
	}

	@PostMapping("/insert")
	public Book insertBook(@RequestBody Book book) {
		return  bookRepository.saveAndFlush(book);
	}

	/*
	 * @GetMapping("/bookCopies/{id}") public int getAvailableCopies(@PathVariable
	 * String id) {
	 * 
	 * 
	 * return 0; }
	 */
	
}
