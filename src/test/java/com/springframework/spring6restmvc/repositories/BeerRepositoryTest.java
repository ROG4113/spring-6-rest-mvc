package com.springframework.spring6restmvc.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springframework.spring6restmvc.entites.Beer;
import com.springframework.spring6restmvc.model.BeerStyle;

import jakarta.validation.ConstraintViolationException;

@DataJpaTest
public class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

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
