package com.samcancode.services;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.samcancode.web.model.BeerOrderDto;
import com.samcancode.web.model.BeerOrderPagedList;

public interface BeerOrderService {
    BeerOrderPagedList listOrders(UUID customerId, Pageable pageable);

    BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto);

    BeerOrderDto getOrderById(UUID customerId, UUID orderId);

    void pickupOrder(UUID customerId, UUID orderId);
}