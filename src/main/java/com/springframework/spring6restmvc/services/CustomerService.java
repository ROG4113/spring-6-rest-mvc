package com.springframework.spring6restmvc.services;

import java.util.List;
import java.util.UUID;

import com.springframework.spring6restmvc.model.Customer;

public interface CustomerService {

    Customer getCustomerById(UUID id);

    List<Customer> getAllCustomers();

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID id, Customer customer);

    void deleteCustomerById(UUID id);

    void patchCustomerById(UUID id, Customer customer);
}
