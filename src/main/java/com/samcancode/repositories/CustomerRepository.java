package com.samcancode.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samcancode.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}