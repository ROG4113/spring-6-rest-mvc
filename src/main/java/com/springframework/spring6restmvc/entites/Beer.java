package com.springframework.spring6restmvc.entites;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springframework.spring6restmvc.model.BeerStyle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
    @Id
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length =36, columnDefinition = "varchar", updatable = false, nullable = false)
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("version")
    @Version
    private Integer version;

    @JsonProperty("beerName")
    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(length=50)
    private String beerName;
    
    @JsonProperty("beerStyle")
    @NotNull
    private BeerStyle beerStyle;
    

    @JsonProperty("upc")
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String upc;
    
    @JsonProperty("quantityOnHand")
    private Integer quantityOnHand;
    
    @JsonProperty("price")
    @NotNull
    private BigDecimal price;
    
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
