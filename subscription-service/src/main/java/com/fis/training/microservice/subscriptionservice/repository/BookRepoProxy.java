package com.fis.training.microservice.subscriptionservice.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fis.training.microservice.subscriptionservice.bean.Book;


@FeignClient(name="book-service", url="localhost:8080")
public interface BookRepoProxy {

	@GetMapping("/books")
	public Book retrieveBooks();
	
	@GetMapping("/book/{id}")
	public Book bookById(@PathVariable String id);

	@PostMapping("/insert")
	public Book saveBook(@RequestBody Book book);
}
