package com.springframework.spring6restmvc.services;

import java.util.UUID;

import com.springframework.spring6restmvc.model.Beer;

public interface BeerService {
    Beer getBeerById(UUID id);
}
