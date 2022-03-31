package com.demo.client;

import com.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CustomerClient {

    private final WebClient webClient;

    @Autowired
    public CustomerClient(WebClient.Builder clientBuilder, String baseUrl) {
        
        this.webClient = clientBuilder.clone().baseUrl(baseUrl).build();
    }
    
    public Customer findById(Integer customerId) {
        return webClient.get()
                .uri("/customers/{id}", customerId)
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
    }
    
}
