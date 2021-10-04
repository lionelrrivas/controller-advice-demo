package com.fedex.service;

import com.fedex.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fedex.repository.CustomerRepository;

@Component
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public Customer findById(Integer id) {
        return this.customerRepository.findById(id);
    } 
}
