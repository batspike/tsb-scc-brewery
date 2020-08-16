package com.samcancode.web.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.hasSize;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.samcancode.services.BeerOrderService;
import com.samcancode.web.model.BeerDto;
import com.samcancode.web.model.BeerOrderDto;
import com.samcancode.web.model.BeerOrderLineDto;
import com.samcancode.web.model.BeerOrderPagedList;
import com.samcancode.web.model.BeerStyleEnum;

@WebMvcTest(BeerOrderController.class)
class BeerOrderControllerTest {
	@MockBean //Spring will inject via autowired
	BeerOrderService beerOrderService;
	
	@Autowired
	MockMvc mockMvc; //Spring will create for us via autowiring
	
	BeerDto validBeer;
	BeerOrderDto beerOrder;
	BeerOrderPagedList beerOrderPagedList;

	@BeforeEach
	void setUp() throws Exception {
		validBeer = BeerDto.builder().id(UUID.randomUUID())
				.version(1)
				.beerName("Beer1")
				.beerStyle(BeerStyleEnum.PALE_ALE)
				.price(new BigDecimal("12.99"))
				.quantityOnHand(4)
				.upc(123456789012L)
				.createdDate(OffsetDateTime.now())
				.lastModifiedDate(OffsetDateTime.now())
				.build();
		
		beerOrder = BeerOrderDto.builder()
						.id(UUID.randomUUID())
						.customerRef("1234")
						.beerOrderLines(List.of(BeerOrderLineDto.builder().beerId(validBeer.getId()).build()))
						.build();
		
		beerOrderPagedList = new BeerOrderPagedList( List.of(beerOrder), PageRequest.of(1,1), 1L );
		
	}
	
	@AfterEach
	void tearDown() {
		reset(beerOrderService); //this will reset all the beerOrderService properties after each test
	}


	@Test
	void testListOrders() throws Exception {
		given(beerOrderService.listOrders(any(), any())).willReturn(beerOrderPagedList);
		
		mockMvc.perform(get("/api/v1/customers/806a95e3-2fef-4cd0-b55d-7d9b63e1d73e/orders"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void testGetOrder() throws Exception {
		given(beerOrderService.getOrderById(any(), any())).willReturn(beerOrder);
		
		mockMvc.perform(get("/api/v1/customers/806a95e3-2fef-4cd0-b55d-7d9b63e1d73e/orders/806a95e3-2fef-4cd0-b55d-7d9b63e1d73e"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

}
