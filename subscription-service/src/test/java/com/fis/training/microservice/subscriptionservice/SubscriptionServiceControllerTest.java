package com.fis.training.microservice.subscriptionservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.fis.training.microservice.subscriptionservice.repository.SubscriptionRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SubscriptionServiceControllerTest {
	
	@Mock
	SubscriptionServiceController controller;

	@InjectMocks
	SubscriptionRepository repository;
	
	@Test
	public void testShow() {
		
	}
}
