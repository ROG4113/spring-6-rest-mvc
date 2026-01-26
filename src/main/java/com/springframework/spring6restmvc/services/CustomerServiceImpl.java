package com.springframework.spring6restmvc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springframework.spring6restmvc.model.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService{

    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl(){
        customerMap=new HashMap<>();

        CustomerDTO customer1=CustomerDTO.builder()
            .id(UUID.randomUUID())
            .name("Customer 1")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();

        CustomerDTO customer2=CustomerDTO.builder()
            .id(UUID.randomUUID())
            .name("Customer 2")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();

        CustomerDTO customer3=CustomerDTO.builder()
            .id(UUID.randomUUID())
            .name("Customer 3")
            .version(1)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }
    
    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customer) {
        
        CustomerDTO existingCustomer=customerMap.get(customerId);

        if(StringUtils.hasText(customer.getName())){
            existingCustomer.setName(customer.getName());
        }
        
    }
    
    @Override
    public void deleteCustomerById(UUID customerId) {
        
        customerMap.remove(customerId);
        
    }
    
    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {
        
        CustomerDTO existingCustomer=customerMap.get(customerId);

        existingCustomer
            .setName(customer.getName());
        
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        
        CustomerDTO newCustomer=CustomerDTO.builder()
            .id(UUID.randomUUID())
            .version(1)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .name(customer.getName())
            .build();

        customerMap.put(newCustomer.getId(), newCustomer);

        return newCustomer;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID uuid) {
        
        CustomerDTO customer=customerMap.get(uuid);

        return Optional.of(customer);
    }
    
    @Override
    public List<CustomerDTO> getAllCustomers() {
        
        List<CustomerDTO> list=new ArrayList<>(customerMap.values());

        return list;
    }
}
