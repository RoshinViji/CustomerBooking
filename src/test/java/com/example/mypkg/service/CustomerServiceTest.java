package com.example.mypkg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.mypkg.entity.Customer;
import com.example.mypkg.repository.CustomerRepository;

@SpringBootTest

class CustomerServiceTest {
	@Autowired
	private CustomerService customerservice;
	@MockBean
	private CustomerRepository repository;

	@Test
	public void getCustomerTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Customer(1, "roshin", "viji", null, "roshin.viji@people10.com", "123456"),
						new Customer(22, "mani", "p", null, "manip@gmail.com", "manip12456"))
				.collect(Collectors.toList()));
		assertEquals(2, customerservice.getCustomer().size());

	}

	@Test
	public void saveCustomerTest() {
		Customer customer = new Customer(98, "m", "rosh", null, "mrosh@gmail.com", "dania123456");
		when(repository.save(customer)).thenReturn(customer);
		equals(customerservice.saveCustomer(customer));

	}
	@Test
    public void getCustomerByIdTest() {
        
        Optional<Customer> customer=Optional.ofNullable(new Customer(45,"manu","p",null,"marup@gmail.com","marup1234"));
        Mockito.when(repository.findById(45)).thenReturn(customer);
        String firstname="manu";
        Customer id= customerservice.getCustomerById(45);
        assertEquals(firstname, id.getFirstname());
    }

}