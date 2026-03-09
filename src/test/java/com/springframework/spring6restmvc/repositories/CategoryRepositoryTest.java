package com.springframework.spring6restmvc.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springframework.spring6restmvc.entites.Beer;
import com.springframework.spring6restmvc.entites.Category;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BeerRepository beerRepository;
    Beer testBeer;

    @BeforeEach
    void setup(){
        testBeer=beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void testAddCategory(){
        Category savedCategory=categoryRepository.save(Category
                                                .builder()
                                                .description("Ales")
                                                .build());

        testBeer.addCategory(savedCategory);
        Beer saveBeer=beerRepository.save(testBeer);
        
        System.out.println(saveBeer.getBeerName());
    }
}
