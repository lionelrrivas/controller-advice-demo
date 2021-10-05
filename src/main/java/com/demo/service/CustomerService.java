package com.demo.service;

import com.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo.repository.CustomerRepository;

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
