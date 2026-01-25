package com.springframework.spring6restmvc.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring6restmvc.entites.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
