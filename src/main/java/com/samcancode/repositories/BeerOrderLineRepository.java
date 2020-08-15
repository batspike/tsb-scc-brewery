package com.samcancode.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.samcancode.domain.BeerOrderLine;

public interface BeerOrderLineRepository extends PagingAndSortingRepository<BeerOrderLine, UUID> {
}