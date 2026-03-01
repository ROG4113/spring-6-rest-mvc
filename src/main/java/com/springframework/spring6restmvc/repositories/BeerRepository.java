package com.springframework.spring6restmvc.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.spring6restmvc.entites.Beer;
import com.springframework.spring6restmvc.model.BeerStyle;

public interface BeerRepository extends JpaRepository<Beer, UUID>{

    List<Beer> findAllByBeerNameIsLikeIgnoreCase(String beerName);

    List<Beer> findAllByBeerStyle(BeerStyle beerStyle);

    List<Beer> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beername, BeerStyle beerStyle);
}
