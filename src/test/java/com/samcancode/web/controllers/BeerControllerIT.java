package com.samcancode.web.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.samcancode.web.model.BeerPagedList;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeerControllerIT {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testListBeersIT() {
		BeerPagedList beerPagedList = restTemplate.getForObject("/api/v1/beer", BeerPagedList.class);
		assertThat(beerPagedList.getContent()).hasSize(3);
	}

}
