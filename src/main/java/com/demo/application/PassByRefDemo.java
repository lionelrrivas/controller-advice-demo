package com.demo.application;

import java.util.HashSet;

public class PassByRefDemo {
    
    public void setResponse(Response response) {
        response = new Response();
        response.setAccountNumber("456");
    }
    
    
    public static void main(String[] args) {
        PassByRefDemo demo = new PassByRefDemo();
        
        Response response = new Response();
        response.setAccountNumber("123");
        
        System.out.println(response.getAccountNumber());
        
        demo.setResponse(response);
        
        System.out.println(response.getAccountNumber());
        
    }
    
    
}
 