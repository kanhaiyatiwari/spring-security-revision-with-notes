package com.Spring.servises;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Spring.entity.Customer;
import com.Spring.repos.CustomerRepo;

@Service
public class CustomerUserDtailSrviseImpl implements UserDetailsService{
@Autowired
	private CustomerRepo crepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> opt= crepo.findByEmail(username);
		if(opt.isPresent()) {
		Customer customer= opt.get();
		//Empty Authorities
		List<GrantedAuthority> authorities= new ArrayList<>();
		//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
		return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(), authorities);
		//return new CustomerUserDetails(customer);
		}else
		throw new BadCredentialsException("User Details not found with this username: "+username);
	}

}
