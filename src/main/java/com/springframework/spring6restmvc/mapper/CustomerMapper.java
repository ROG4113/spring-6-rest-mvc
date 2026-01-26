package com.springframework.spring6restmvc.mapper;

import org.mapstruct.Mapper;

import com.springframework.spring6restmvc.entites.Customer;
import com.springframework.spring6restmvc.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);

}
