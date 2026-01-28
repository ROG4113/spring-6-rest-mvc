package com.springframework.spring6restmvc.controller;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.springframework.spring6restmvc.entites.Beer;
import com.springframework.spring6restmvc.mapper.BeerMapper;
import com.springframework.spring6restmvc.model.BeerDTO;
import com.springframework.spring6restmvc.repositories.BeerRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BeerControllerIT {

    @Autowired
    BeerController beerController;

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BeerMapper beerMapper;

    @Test
    void testDeleteByIdNotFound(){
        assertThrows(NotFoundException.class, ()->{
            beerController.deleteById(UUID.randomUUID());
        });
    }

    @Transactional
    @Rollback
    @Test
    void deleteByIdFound(){
        Beer beer=beerRepository.findAll().get(0);

        ResponseEntity responseEntity=beerController.deleteById(beer.getId());

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
        assertThat(beerRepository.findById(beer.getId()).isEmpty());
        // Beer foundBeer=beerRepository.findById(beer.getId()).get();
        // assertThat(foundBeer).isNull();
    }

    @Test
    void testUpdateNotFound(){
        assertThrows(NotFoundException.class, ()->{
            beerController.updateById(UUID.randomUUID(), BeerDTO.builder().build());
        });
    }

    @Transactional
    @Rollback
    @Test
    void updateExistingBeer(){
        Beer beer=beerRepository.findAll().get(0);
        BeerDTO beerDTO=beerMapper.beerToBeerDto(beer);
        
        beerDTO.setId(null);
        beerDTO.setVersion(null);
        
        final String beerName="UPDATED";
        beerDTO.setBeerName(beerName);

        ResponseEntity responseEntity=beerController.updateById(beer.getId(), beerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        Beer updatedBeer=beerRepository.findById(beer.getId()).get();
        assertThat(updatedBeer.getBeerName()).isEqualTo(beerName);
    }

    @Transactional
    @Rollback
    @Test
    void saveNewBeerTest(){
        BeerDTO beerDTO=BeerDTO.builder()
                                .beerName("New Beer")
                                .build();

        ResponseEntity responseEntity=beerController.handlePost(beerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID=responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID=UUID.fromString(locationUUID[4]);

        Beer beer=beerRepository.findById(savedUUID).get();

        assertThat(beer).isNotNull();
    }

    @Test
    void testBeerIdNotFound(){
        assertThrows(NotFoundException.class, ()->{
            beerController.getBeerById(UUID.randomUUID());
        });
    }    

    @Test
    void testGetById(){
        Beer beer=beerRepository.findAll().get(0);

        BeerDTO dto=beerController.getBeerById(beer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testListBeers(){
        List<BeerDTO> dtos=beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    // @Transactional rolls back
    @Transactional
    @Rollback
    @Test
    void testEmptyList(){
        beerRepository.deleteAll();

        List<BeerDTO> dtos=beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(0);
    }

}
