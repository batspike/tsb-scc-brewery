package com.samcancode.services;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;

import com.samcancode.web.model.BeerDto;
import com.samcancode.web.model.BeerPagedList;
import com.samcancode.web.model.BeerStyleEnum;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    BeerDto findBeerById(UUID beerId);
}