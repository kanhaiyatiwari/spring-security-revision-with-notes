package com.day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/intro")
	public String my() {
	return "hi i am kanhiaya tiwari";
	
	}
	@GetMapping("/hello")
	public String hello() {
	return "hello everyOne";
	
	}
}
