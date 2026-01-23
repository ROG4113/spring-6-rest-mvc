package com.springframework.spring6restmvc.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;
import lombok.Data;

@JsonDeserialize(builder=Beer.BeerBuilder.class)
@Builder
@Data
public class Customer {
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("version")
    private Integer version;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
