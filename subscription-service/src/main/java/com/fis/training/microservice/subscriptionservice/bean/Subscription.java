package com.fis.training.microservice.subscriptionservice.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription {

	@Id
	private String subscriberName;
	private String bookId;
	private String dateSubscribed;
	private String dateReturned;
	
	
	
	public Subscription() {
	}

	

	public Subscription(String subscriberName, String bookId, String dateSubscribed, String dateReturned) {
		super();
		this.subscriberName = subscriberName;
		this.bookId = bookId;
		this.dateSubscribed = dateSubscribed;
		this.dateReturned = dateReturned;
	}



	public String getSubscriberName() {
		return subscriberName;
	}



	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}



	public String getBookId() {
		return bookId;
	}



	public void setBookId(String bookId) {
		this.bookId = bookId;
	}



	public String getDateSubscribed() {
		return dateSubscribed;
	}



	public void setDateSubscribed(String dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}



	public String getDateReturned() {
		return dateReturned;
	}



	public void setDateReturned(String dateReturned) {
		this.dateReturned = dateReturned;
	}



	@Override
	public String toString() {
		return "Subscription [subscriberName=" + subscriberName + ", bookId=" + bookId + ", dateSubscribed="
				+ dateSubscribed + ", dateReturned=" + dateReturned + "]";
	}
	
	
}
