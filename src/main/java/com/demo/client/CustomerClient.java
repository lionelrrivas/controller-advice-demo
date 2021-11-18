package com.demo.client;

import com.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CustomerClient {

    private final WebClient webClient;

    @Autowired
    public CustomerClient(WebClient.Builder clientBuilder) {
        clientBuilder.build();
        this.webClient = clientBuilder.build();
    }
    
    public Customer findById(Integer customerId) {
        return webClient.get()
                .uri("/customers/{id}", customerId)
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
    }
    
}
