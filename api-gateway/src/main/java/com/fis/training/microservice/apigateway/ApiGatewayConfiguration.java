package com.fis.training.microservice.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApiGatewayConfiguration {

	//Capabilty to modify route
	//routing function
//	@Bean
	public RouteLocator gatewayLocator(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> function=p->p.path("/get").
				filters(f->f.addRequestHeader("MyHeader", "MyValue")).
						uri("http://httpbin.org:80");
		
		return builder.routes().route(function).
				route(p -> p.path("/subscription/**").uri("lb://subscription")).
				build();
		
		
	}
}
