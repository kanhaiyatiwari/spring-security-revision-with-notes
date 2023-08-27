package com.Spring.servises;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Spring.entity.Customer;
import com.Spring.exception.CustomerException;
import com.Spring.repos.CustomerRepo;
@Service
public class CustomerServisesImpl implements CustomerServise{

	private CustomerRepo crepo;
	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return crepo.save(customer);
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer>opt=crepo.findByEmail(email);
		if(opt.isPresent()) return opt.get();
			
		
		throw  new CustomerException("Customer Not found with Email: "+email);
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> customers=crepo.findAll();
		if(customers.isEmpty()) throw new  CustomerException("there is no customer in database");
			
		return customers;
	}

}
