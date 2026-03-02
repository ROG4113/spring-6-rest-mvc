package com.springframework.spring6restmvc.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import com.springframework.spring6restmvc.bootstrap.BootstrapData;
import com.springframework.spring6restmvc.entites.Beer;
import com.springframework.spring6restmvc.model.BeerStyle;
import com.springframework.spring6restmvc.services.BeerCsvServiceImpl;

import jakarta.validation.ConstraintViolationException;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
public class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testGetBeerListByName(){
        Page<Beer> list=beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }

    @Test
    void testSaveBeerNameTooLong(){
        assertThrows(ConstraintViolationException.class, ()->{
            Beer savedBeer=beerRepository.save(Beer.builder()
                                        .beerName("My Beer 123456789123456789123456789123456789123456789123456789123456789")
                                        .beerStyle(BeerStyle.PALE_ALE)
                                        .upc("123456")
                                        .price(new BigDecimal("11.99"))
                                        .build());

            beerRepository.flush();
        });
        
        // assertThat(savedBeer).isNotNull();
        // assertThat(savedBeer.getId()).isNotNull();
    }

    @Test
    void testSaveBeer(){

        Beer savedBeer=beerRepository.save(Beer.builder()
                                        .beerName("My Beer")
                                        .beerStyle(BeerStyle.PALE_ALE)
                                        .upc("123456")
                                        .price(new BigDecimal("11.99"))
                                        .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();

    }
}
