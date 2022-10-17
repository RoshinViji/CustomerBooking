package com.example.mypkg.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.example.mypkg.entity.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.mypkg.repository.CustomerRepository;

class CustomerServiceTest {

	
	@MockBean
	private CustomerRepository repository;
	
	@Autowired
	private CustomerService customerservice;
	
	
	
}
