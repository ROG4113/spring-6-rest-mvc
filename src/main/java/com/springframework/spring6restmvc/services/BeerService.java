package com.springframework.spring6restmvc.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.springframework.spring6restmvc.model.BeerDTO;
import com.springframework.spring6restmvc.model.BeerStyle;

public interface BeerService {
    Optional<BeerDTO> getBeerById(UUID id);

    Page<BeerDTO> listBeer(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    Boolean deleteBeerById(UUID Id);

    Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer);
}
