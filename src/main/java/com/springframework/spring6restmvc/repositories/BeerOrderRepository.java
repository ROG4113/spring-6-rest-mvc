package com.springframework.spring6restmvc.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring6restmvc.entites.BeerOrder;

public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {

}
