package com.springframework.spring6restmvc.mapper;

import org.mapstruct.Mapper;

import com.springframework.spring6restmvc.entites.Beer;
import com.springframework.spring6restmvc.model.BeerDTO;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

}
