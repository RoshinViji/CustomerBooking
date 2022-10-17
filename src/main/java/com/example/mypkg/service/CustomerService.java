package com.example.mypkg.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mypkg.entity.Customer;
import com.example.mypkg.exception.ResourceNotFoundException;
import com.example.mypkg.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerService1 {
@Autowired
private CustomerRepository repository;
	@Override
	public String saveCustomer(Customer Customer) {
		repository.save(Customer);
		
	   return "Customer Saved";
	}

	@Override
	public List<Customer> getCustomer() {
		
		return repository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
	
	Customer customer=repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException ("customer","id",id));
	return customer;
	}


	    
	}



