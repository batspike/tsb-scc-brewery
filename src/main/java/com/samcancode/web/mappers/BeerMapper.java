package com.samcancode.web.mappers;

import org.mapstruct.Mapper;

import com.samcancode.domain.Beer;
import com.samcancode.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}