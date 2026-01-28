package com.springframework.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
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
    public Boolean deleteBeerById(UUID id) {
        // TODO Auto-generated method stub
        if(beerRepository.existsById(id)){
            beerRepository.deleteById(id);
            return true;
        }

        return false;
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
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beer)));
    }

    @Override
    public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer) {
        // TODO Auto-generated method stub
        AtomicReference<Optional<BeerDTO>> atomicReference=new AtomicReference<>();

        beerRepository.findById(beerId).ifPresentOrElse(((foundBeer)->{
            foundBeer.setBeerName(beer.getBeerName());
            foundBeer.setBeerStyle(beer.getBeerStyle());
            foundBeer.setUpc(beer.getUpc());
            foundBeer.setPrice(beer.getPrice());

            atomicReference.set(Optional.of(beerMapper
                                            .beerToBeerDto(beerRepository.save(foundBeer))));
        }), ()->{
            atomicReference.set(Optional.empty());
        });
        
        return atomicReference.get();
    }
    
}
