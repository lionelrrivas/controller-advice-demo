package com.demo.client;

import com.demo.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

public class CustomerClientTest {
    
    private static MockWebServer mockWebServer;
    private CustomerClient customerClient;
    private final ObjectMapper MAPPER = new ObjectMapper();

    @BeforeAll
    static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://" + mockWebServer.getHostName() + ":%s", mockWebServer.getPort());
        customerClient = new CustomerClient(WebClient.builder().baseUrl(baseUrl));
    }
    
    @Test
    void testFindCustomerById() throws Exception {
        Customer expectedCustomer = new Customer("John", "Doe", 1);
        
        mockWebServer.enqueue(new MockResponse().setBody(MAPPER.writeValueAsString(expectedCustomer))
                .addHeader("Content-Type", "application/json"));

        Customer actualCustomer = customerClient.findById(1);

//        StepVerifier.create(employeeMono)
//                .expectNextMatches(employee -> employee.getRole().equals(Role.LEAD_ENGINEER))
//                .verifyComplete();

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/customers/1", recordedRequest.getPath());
        assertEquals(expectedCustomer, actualCustomer);
    }
    
}
