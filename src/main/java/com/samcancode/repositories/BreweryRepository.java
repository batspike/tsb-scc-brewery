package com.samcancode.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samcancode.domain.Brewery;

public interface BreweryRepository extends JpaRepository<Brewery, UUID> {
}