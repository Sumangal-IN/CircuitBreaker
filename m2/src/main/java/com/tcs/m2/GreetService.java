package com.tcs.m2;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GreetService {
	@HystrixCommand(fallbackMethod = "abcd")
	public String getGreeting(String username) {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create("http://localhost:9090/greeting/" + username);
		return restTemplate.getForObject(uri, String.class);
	}

	public String abcd(String username) {
		return "Can't process "+username+" at this moment. Please try again later.";
	}
}
