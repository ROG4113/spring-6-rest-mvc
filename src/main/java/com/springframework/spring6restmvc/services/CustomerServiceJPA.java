package com.springframework.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springframework.spring6restmvc.mapper.CustomerMapper;
import com.springframework.spring6restmvc.model.CustomerDTO;
import com.springframework.spring6restmvc.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {
    
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    
    @Override
    public void deleteCustomerById(UUID id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void patchCustomerById(UUID id, CustomerDTO customer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateCustomerById(UUID id, CustomerDTO customer) {
        // TODO Auto-generated method stub
        
    }
    
}
