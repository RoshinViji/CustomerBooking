package com.example.mypkg.service;

import java.util.List;

import com.example.mypkg.entity.Customer;

public interface CustomerService1 {
	String saveCustomer(Customer Customer);
	List<Customer>getCustomer();
	Customer getCustomerById(int id);
	
	}

