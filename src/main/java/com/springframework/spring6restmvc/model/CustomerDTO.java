package com.springframework.spring6restmvc.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;
import lombok.Data;

@JsonDeserialize(builder=CustomerDTO.CustomerDTOBuilder.class)
@Builder
@Data
public class CustomerDTO {
    @JsonProperty("id")
    private UUID id;
    
    @JsonProperty("name")
    private String name;

    @JsonProperty("version")
    private Integer version;

    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
