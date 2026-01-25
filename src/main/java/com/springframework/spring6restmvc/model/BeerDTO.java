package com.springframework.spring6restmvc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;
import lombok.Data;

@JsonDeserialize(builder=BeerDTO.BeerDTOBuilder.class)
@Builder
@Data
public class BeerDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("beerName")
    private String beerName;
    
    @JsonProperty("beerStyle")
    private BeerStyle beerStyle;
    
    @JsonProperty("upc")
    private String upc;
    
    @JsonProperty("quantityOnHand")
    private Integer quantityOnHand;
    
    @JsonProperty("price")
    private BigDecimal price;
    
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
