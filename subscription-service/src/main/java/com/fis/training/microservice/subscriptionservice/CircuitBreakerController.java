package com.fis.training.microservice.subscriptionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {


	private static final Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping(value = "/sampleapi")
	@Retry(name = "default", fallbackMethod = "fallbackMsg")
	private String sampleApi()
	{

		log.info("inside method");
		ResponseEntity<String> entity =new RestTemplate().getForEntity("https://localhost:8888/dummy-url", String.class);

		return entity.getBody();
	}

	public String fallbackMsg(Exception e) {
		return "Fallback response";
	}
}
