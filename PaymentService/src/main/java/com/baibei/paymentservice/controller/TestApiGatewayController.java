package com.baibei.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiGatewayController {

    @GetMapping("/api/payment/test")
    public String testApi() {
        return "All works!";
    }
}
