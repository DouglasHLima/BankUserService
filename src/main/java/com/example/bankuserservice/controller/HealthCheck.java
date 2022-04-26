package com.example.bankuserservice.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/health-check")
public class HealthCheck {

    @GetMapping("")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("i'm still alive!!");
    }

}
