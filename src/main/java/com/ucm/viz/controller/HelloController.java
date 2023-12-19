package com.ucm.viz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloController {

	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World , Good Morning...";
		
	}
	
	
	
}
