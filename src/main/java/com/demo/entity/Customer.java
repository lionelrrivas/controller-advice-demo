package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    public Customer() {}
        
    private String firstName;
    private String lastName;
    private Integer id;
}
