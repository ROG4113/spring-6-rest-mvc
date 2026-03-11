package com.springframework.spring6restmvc.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.springframework.spring6restmvc.entites.Beer;
import com.springframework.spring6restmvc.entites.BeerOrder;
import com.springframework.spring6restmvc.entites.BeerOrderShipment;
import com.springframework.spring6restmvc.entites.Customer;

@SpringBootTest
public class BeerOrderRepositoryTest {
    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerRepository beerRepository;

    Customer testCustomer;
    Beer testBeer;

    @BeforeEach
    void setup(){
        testCustomer=customerRepository.findAll().get(0);
        testBeer=beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void testBeerOrders(){
        BeerOrder beerOrder=BeerOrder.builder()
        .customerRef("Test order")
        .customer(testCustomer)
        .beerOrderShipment(BeerOrderShipment.builder().trackingNumber("1234").build())                            
        .build();

        BeerOrder savedBeerOrder=beerOrderRepository.save(beerOrder);
        
        System.out.println(savedBeerOrder.getCustomerRef());
    }
}
