package com.masai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/hello1")
	public String hello1() {
		return "this is hello1 without security";
	}
	@GetMapping("/hello2")
	public String hello2() {
		return "this is hello2 with security";
	}
}
