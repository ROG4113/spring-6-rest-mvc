package com.springframework.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springframework.spring6restmvc.mapper.BeerMapper;
import com.springframework.spring6restmvc.model.BeerDTO;
import com.springframework.spring6restmvc.repositories.BeerRepository;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public void deleteBeerById(UUID Id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        // TODO Auto-generated method stub

        return Optional.ofNullable(beerMapper.beerToBeerDto(beerRepository.findById(id)
                                            .orElse(null)));

    }

    @Override
    public List<BeerDTO> listBeer() {
        // TODO Auto-generated method stub
        return beerRepository.findAll()
                            .stream()
                            .map(beerMapper::beerToBeerDto)
                            .collect(Collectors.toList());
    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO beer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateBeerById(UUID beerId, BeerDTO beer) {
        // TODO Auto-generated method stub
        
    }
    
}
