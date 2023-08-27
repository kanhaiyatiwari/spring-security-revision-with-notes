package com.Spring.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.entity.Customer;
import com.Spring.servises.CustomerServise;

@RestController
public class CustomerController {
@Autowired
	private CustomerServise  cs;
@Autowired
	private PasswordEncoder passwordEncoder;

@GetMapping("/hello")
public String printHello() {
	return "hello";
}
@PostMapping("/customer")
public ResponseEntity<Customer> saveCustomerHendller(@RequestBody Customer customer){
	customer.setPassword(passwordEncoder.encode(customer.getPassword()));
	Customer registerd=cs.registerCustomer(customer);
	return new ResponseEntity<>(registerd,HttpStatus.ACCEPTED);
	
}

@GetMapping("/customer/{email}")
public ResponseEntity<Customer> findCustomer(@PathVariable("email") String email){
	
	Customer customer =cs.getCustomerDetailsByEmail(email);
	return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
}
@GetMapping("/customer")
public ResponseEntity<List<Customer>> findAllCustomer(){
	
	List<Customer> customers=cs.getAllCustomerDetails();
return new ResponseEntity<>(customers,HttpStatus.ACCEPTED);
}

@GetMapping("/signIn")
public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
System.out.println(auth); // this Authentication object having Principle object details
Customer customer= cs.getCustomerDetailsByEmail(auth.name());
return new ResponseEntity<>(customer.getName()+"Logged In Successfully", HttpStatus.ACCEPTED);
}
}