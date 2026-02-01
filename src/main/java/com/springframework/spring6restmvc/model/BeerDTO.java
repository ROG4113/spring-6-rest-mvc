package com.springframework.spring6restmvc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@JsonDeserialize(builder=BeerDTO.BeerDTOBuilder.class)
@Builder
@Data
public class BeerDTO {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("version")
    @Version
    private Integer version;

    @JsonProperty("beerName")
    @NotBlank
    @NotNull
    private String beerName;
    
    @JsonProperty("beerStyle")
    @NotNull
    private BeerStyle beerStyle;
    
    @JsonProperty("upc")
    @NotNull
    @NotBlank
    private String upc;
    
    @JsonProperty("quantityOnHand")
    private Integer quantityOnHand;
    
    @JsonProperty("price")
    @NotNull
    private BigDecimal price;
    
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
