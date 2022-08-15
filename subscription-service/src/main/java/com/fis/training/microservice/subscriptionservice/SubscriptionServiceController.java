package com.fis.training.microservice.subscriptionservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fis.training.microservice.subscriptionservice.bean.Book;
import com.fis.training.microservice.subscriptionservice.bean.Subscription;
import com.fis.training.microservice.subscriptionservice.repository.BookRepoProxy;
import com.fis.training.microservice.subscriptionservice.repository.SubscriptionRepository;


@RestController
public class SubscriptionServiceController {
	
	@Autowired
	BookRepoProxy proxy;
	@Autowired
	SubscriptionRepository repository;

	@GetMapping("/subscriptions")
	public Subscription retrieveSubscription() {
		return new Subscription("x", "y", "z", "u");
		
	}
	
	@GetMapping(value = "/getbookstring")
	private String getStudentStringWithRestTemplate()
	{
	    String uri = "http://localhost:8080/books";
	//	 String uri = "http://localhost:8080/subscriptions";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    return result; 
	}
	
	
	@GetMapping(value = "/getbookstringfeign")
	private Book getStudentStringWithFeign()
	{
		
		System.out.println("proxy.retrieveBooks() "+proxy.retrieveBooks());
		return proxy.retrieveBooks();
	   // return result; 
	}
	
	@GetMapping(value = "/book/{id}")
	private Book getBookById(@PathVariable String id)
	{
		Book bookById = proxy.bookById(id);
		System.out.println("proxy.retrieveBooks() "+proxy.bookById(id));
		return bookById;
	}
	
	@GetMapping(value = "/show")
	private List<Subscription> show()
	{
		return repository.findAll();
	}

	@PostMapping(value = "/insert")
	@Transactional(propagation = Propagation.MANDATORY)
	private Subscription insertSubscription(@RequestBody Subscription subscription)
	{
		String bookId = subscription.getBookId();
		Book bookById = proxy.bookById(bookId);
		if(bookById.getAvailable_copies()>0) {
			bookById.setAvailable_copies(bookById.getAvailable_copies() - 1);
			proxy.saveBook(bookById);
			return repository.saveAndFlush(subscription);
		}else {
			return null;
		}
	}
	

}
