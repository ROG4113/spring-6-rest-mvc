package com.springframework.spring6restmvc.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.spring6restmvc.model.Beer;
import com.springframework.spring6restmvc.services.BeerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PatchMapping("{beerId}")
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer){

        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeerById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer){
        
        beerService.updateBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Beer beer){
        Beer savedBeer=beerService.saveNewBeer(beer);

        HttpHeaders header=new HttpHeaders();
        header.add("location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity(header, HttpStatus.CREATED) ;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Beer> listBeers(){
        return beerService.listBeer();
    }

    @RequestMapping(value="{beerId}", method =RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId){
        
        log.debug("Get Beer By Id - in controller");

        return beerService.getBeerById(beerId);
    }
}
