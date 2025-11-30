package com.springframework.spring6restmvc.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.springframework.spring6restmvc.services.BeerService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @SpringBootTest
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    // @Autowired
    // BeerController beerController;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerService beerService;

    @Test
    void testGetBeerById() throws Exception {
        // System.out.println(beerController.getBeerById(UUID.randomUUID()));
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
