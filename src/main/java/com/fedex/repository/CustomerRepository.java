package com.fedex.repository;

import java.util.HashMap;
import java.util.Map;
import com.fedex.entity.Customer;
import com.fedex.exception.CustomerNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepository {
    
    private static final Map<Integer, Customer> CUSTOMERS = new HashMap<>();
    
    static {
        CUSTOMERS.put(1, new Customer("Jane", "Doe", 1));
        CUSTOMERS.put(2, new Customer("Jhon", "Doe", 2));
        CUSTOMERS.put(3, new Customer("Adam", "Smith", 3));
    }
    
    public Customer findById(Integer id) {
        if (CUSTOMERS.get(id) == null) {
            throw new CustomerNotFoundException("No customer found for id " + id);
        }
        return CUSTOMERS.get(id);
    }
    
}
