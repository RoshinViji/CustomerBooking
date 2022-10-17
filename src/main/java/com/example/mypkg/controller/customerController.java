package com.example.mypkg.controller;

	import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypkg.entity.Customer;
import com.example.mypkg.service.CustomerService;

	

	@RestController
	public class customerController {
    
@Autowired
public CustomerService service;
		
		@PostMapping(value="/detail") 
		@ResponseStatus(code = HttpStatus.CREATED)
		public String addCustomer(@Valid @RequestBody Customer Customer) {
			return  service.saveCustomer(Customer);
		}
 	
		@GetMapping("/detail")
		public List<Customer> findAllCustomers(){
			return service.getCustomer();
		}
		@GetMapping("/detail/{id}")
		public ResponseEntity<Customer>findCustomerById(@PathVariable Integer id){
			Customer newCustomer = service.getCustomerById(id);
			HttpHeaders header = new HttpHeaders();
			header.add("desc", "getting details by id");
			return ResponseEntity.ok().headers(header).body(newCustomer);
		}
		
	
	}



