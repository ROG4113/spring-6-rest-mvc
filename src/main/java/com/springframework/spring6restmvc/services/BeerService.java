package com.springframework.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.springframework.spring6restmvc.model.Beer;

public interface BeerService {
    Optional<Beer> getBeerById(UUID id);

    List<Beer> listBeer();

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteBeerById(UUID Id);

    void patchBeerById(UUID beerId, Beer beer);
}
