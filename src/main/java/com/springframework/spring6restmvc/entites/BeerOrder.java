package com.springframework.spring6restmvc.entites;

import java.security.Timestamp;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.Version;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class BeerOrder {
    
    
    public BeerOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerRef,
            Customer customer, Set<BeerOrderLine> beerOrderLine, BeerOrderShipment beerOrderShipment) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.customerRef = customerRef;
        this.setCustomer(customer);
        this.beerOrderLine = beerOrderLine;
        this.beerOrderShipment=beerOrderShipment;
    }
    //  REASON FOR MANUAL CONSTRUCTOR:
    //  Lombok's @Builder normally uses a generated @AllArgsConstructor, which uses 
    //  direct field assignment (this.customer = customer). This bypasses our custom 
    //  setCustomer() logic for handshaking.

    @Id
    @GeneratedValue(generator="UUID")
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable=false, nullable=false)
    private UUID id;

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    public boolean isNew(){
        return this.id==null;
    }

    private String customerRef;

    public void setCustomer(Customer customer){
        this.customer=customer;
        customer.getBeerOrders().add(this);
    }

    @ManyToOne
    private Customer customer;
    
    @OneToMany(mappedBy = "beerOrder")
    private Set<BeerOrderLine> beerOrderLine;

    @OneToOne
    private BeerOrderShipment beerOrderShipment;
}
