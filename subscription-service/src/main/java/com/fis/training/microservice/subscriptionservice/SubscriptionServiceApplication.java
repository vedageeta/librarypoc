
package com.fis.training.microservice.subscriptionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories("com.fis.training.microservice.subscriptionservice.repository")
public class SubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);
	}

}
