package com.samcancode.web.mappers;

import org.mapstruct.Mapper;

import com.samcancode.domain.Beer;
import com.samcancode.domain.BeerOrder;
import com.samcancode.domain.BeerOrderLine;
import com.samcancode.web.model.BeerOrderDto;
import com.samcancode.web.model.BeerOrderLineDto;

@Mapper(uses = DateMapper.class)
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);

    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    default BeerOrderLine dtoToBeerOrder(BeerOrderLineDto dto){
        return BeerOrderLine.builder()
                .orderQuantity(dto.getOrderQuantity())
                .beer(Beer.builder().id(dto.getBeerId()).build())
                .build();
    }
}