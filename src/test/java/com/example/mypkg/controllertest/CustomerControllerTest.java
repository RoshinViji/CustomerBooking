package com.example.mypkg.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMessage;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.mypkg.controller.CustomerController;
import com.example.mypkg.entity.Customer;
import com.example.mypkg.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = CustomerController.class)
@ExtendWith(SpringExtension.class)

class CustomerControllerTest {
	@MockBean
	private CustomerService customerservice;
	private Customer customer;
	private List<Customer> customerList;

	@InjectMocks
	private CustomerController customercontroller;
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		customer = new Customer(5, "manu", "krishna", null, "manukrishna@gmail.com", "manukrishna123");
		mockMvc = MockMvcBuilders.standaloneSetup(customercontroller).build();
	}

	@AfterEach
	void tearDown() {
		customer = null;

	}

	@Test
	public void GetMappingCustomer() throws Exception {
		when(customerservice.getCustomerById(customer.getId())).thenReturn(customer);
		mockMvc.perform(get("/detail/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	public static String asJsonString(final Object obj) throws JsonProcessingException {
		{
			return new ObjectMapper().writeValueAsString(obj);
		}
	}

	@Test
	public void GetMappingOfAllCustomer() throws Exception {
		when(customerservice.getCustomer()).thenReturn(customerList);
		mockMvc.perform(MockMvcRequestBuilders.get("/detail").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customer))).andDo(MockMvcResultHandlers.print());
		verify(customerservice).getCustomer();
		verify(customerservice, times(1)).getCustomer();
	}

	@Test

	public void PostMappingOfProduct() throws Exception{
	   when(customerservice.saveCustomer(any())).thenReturn(customer);
	   mockMvc.perform(post("/detail").
	           contentType(MediaType.APPLICATION_JSON).
	           content(asJsonString(customer))).
	           andExpect(status().isCreated());
	   verify(customerservice,times(1)).saveCustomer(any());
	}


}
