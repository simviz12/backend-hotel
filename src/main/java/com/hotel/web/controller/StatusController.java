package com.hotel.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class StatusController {

    @GetMapping("/")
    public Map<String, String> status() {
        return Map.of(
            "status", "OK",
            "hotel", "Grand Horizon API",
            "version", "1.0.0",
            "message", "Backend is running. Use /api/hotel/* endpoints."
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}
