package com.springframework.spring6restmvc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springframework.spring6restmvc.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl(){
        customerMap=new HashMap<>();

        Customer customer1=Customer.builder()
            .id(UUID.randomUUID())
            .name("Customer 1")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .build();

        Customer customer2=Customer.builder()
            .id(UUID.randomUUID())
            .name("Customer 2")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .build();

        Customer customer3=Customer.builder()
            .id(UUID.randomUUID())
            .name("Customer 3")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }
    
    @Override
    public void patchCustomerById(UUID customerId, Customer customer) {
        
        Customer existingCustomer=customerMap.get(customerId);

        if(StringUtils.hasText(customer.getName())){
            existingCustomer.setName(customer.getName());
        }
        
    }
    
    @Override
    public void deleteCustomerById(UUID customerId) {
        
        customerMap.remove(customerId);
        
    }
    
    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {
        
        Customer existingCustomer=customerMap.get(customerId);

        existingCustomer
            .setName(customer.getName());
        
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        
        Customer newCustomer=Customer.builder()
            .id(UUID.randomUUID())
            .version(1)
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .name(customer.getName())
            .build();

        customerMap.put(newCustomer.getId(), newCustomer);

        return newCustomer;
    }

    @Override
    public Customer getCustomerById(UUID uuid) {
        
        Customer customer=customerMap.get(uuid);

        return customer;
    }
    
    @Override
    public List<Customer> getAllCustomers() {
        
        List<Customer> list=new ArrayList<>(customerMap.values());

        return list;
    }
}
