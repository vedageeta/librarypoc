package com.fis.training.microservice.subscriptionservice.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
    private String book_id;
    private String book_name;
    private String author;
    private int available_copies;
    private int total_copies;
    
    
	public Book() {
	}

	public Book(String bookId, String name, String author, int copiesAvailable, int totalCopies) {
		super();
		this.book_id = bookId;
		this.book_name = name;
		this.author = author;
		this.available_copies = copiesAvailable;
		this.total_copies = totalCopies;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getAvailable_copies() {
		return available_copies;
	}

	public void setAvailable_copies(int available_copies) {
		this.available_copies = available_copies;
	}

	public int getTotal_copies() {
		return total_copies;
	}

	public void setTotal_copies(int total_copies) {
		this.total_copies = total_copies;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", author=" + author + ", available_copies="
				+ available_copies + ", total_copies=" + total_copies + "]";
	}
	
	    
}
