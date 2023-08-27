package com.Spring.servises;

import java.util.List;

import com.Spring.entity.Customer;
import com.Spring.exception.CustomerException;

public interface CustomerServise {
	public Customer registerCustomer(Customer customer);
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	public List<Customer> getAllCustomerDetails()throws CustomerException;
}
