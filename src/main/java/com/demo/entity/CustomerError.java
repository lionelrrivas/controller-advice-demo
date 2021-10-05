package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CustomerError {
    
    private String message;
    private String path;
    
}
