package com.example.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @GetMapping
    public String getBankInfo() {
        return "{ \"bank\": \"Example Bank\", \"location\": \"Paris\" }";
    }
}
