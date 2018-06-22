package com.tcs.m2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Autowired
	private GreetService greetService;

	@GetMapping("/get-greeting/{username}")
	public String getGreeting(@PathVariable("username") String username) {
		return greetService.getGreeting(username);
	}
}
