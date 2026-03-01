package com.springframework.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.springframework.spring6restmvc.model.BeerDTO;
import com.springframework.spring6restmvc.model.BeerStyle;

public interface BeerService {
    Optional<BeerDTO> getBeerById(UUID id);

    List<BeerDTO> listBeer(String beerName, BeerStyle beerStyle, Boolean showInventory);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    Boolean deleteBeerById(UUID Id);

    Optional<BeerDTO> patchBeerById(UUID beerId, BeerDTO beer);
}
