package com.lcwd.gateway.ApiGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testing {

    // This is a test controller to verify the API Gateway is working
    // You can add any test endpoints here if needed

    // Example endpoint
    @GetMapping("/test")
    public String testEndpoint() {
        return "API Gateway is up and running!";
    }
}
