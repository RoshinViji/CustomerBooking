package com.example.mypkg.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.mypkg.entity.Customer;
import com.example.mypkg.repository.CustomerRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepositoryTest {
  @Autowired
  private CustomerRepository repository;
  @Test
   public void createCustomer() {
	  Customer customer = new Customer(4,"mani","pp",null,"manipp@gmail.com","manipp123");
	  repository.save(customer);
      Boolean result=repository.existsById(4);
      assertThat(result).isTrue();
  }
  @Test
  @Order(2)
  public void testReadAll() {
      List<Customer> list=repository.findAll();
      assertThat(list).size().isGreaterThan(0);
  }
  }

