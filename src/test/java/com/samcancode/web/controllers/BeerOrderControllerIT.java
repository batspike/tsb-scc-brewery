package com.samcancode.web.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.samcancode.domain.Customer;
import com.samcancode.repositories.CustomerRepository;
import com.samcancode.web.model.BeerOrderPagedList;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeerOrderControllerIT {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	CustomerRepository customerRepository;

	Customer customer;
	
	@BeforeEach
	void setUp() {
		customer = customerRepository.findAll().get(0);
	}
	
	@Test
	void testListOrdersIT() {
		String url = "/api/v1/customers/" + customer.getId().toString() + "/orders";
		
		BeerOrderPagedList beerOrderPagedList = restTemplate.getForObject(url, BeerOrderPagedList.class);
		
		assertThat(beerOrderPagedList.getContent()).hasSize(1);
	}

}
