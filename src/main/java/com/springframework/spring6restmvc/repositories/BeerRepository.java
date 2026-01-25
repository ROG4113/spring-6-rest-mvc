package com.springframework.spring6restmvc.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring6restmvc.entites.Beer;

public interface BeerRepository extends JpaRepository<Beer, UUID>{

}
