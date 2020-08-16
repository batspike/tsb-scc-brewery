package com.samcancode.web.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.core.Is.is;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.samcancode.services.BeerService;
import com.samcancode.web.model.BeerDto;
import com.samcancode.web.model.BeerStyleEnum;

@ExtendWith(MockitoExtension.class)
class BeerControllerTest {
	@Mock
	BeerService beerService;
	
	@InjectMocks
	BeerController beerController;
	
	MockMvc mockMvc;
	BeerDto validBeer;

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
		
		mockMvc = MockMvcBuilders.standaloneSetup(beerController).build();
	}

	@Test
	void testGetBeerById() throws Exception {
		//Given
		given(beerService.findBeerById(any())).willReturn(validBeer);
		
		//When-Then
		mockMvc.perform(get("/api/v1/beer/" + validBeer.getId()))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
			.andExpect(jsonPath("$.beerName", is("Beer1")))
			;
		
	}

}