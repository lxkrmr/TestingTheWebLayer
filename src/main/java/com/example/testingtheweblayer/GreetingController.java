package com.example.testingtheweblayer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingsService service;

    public GreetingController(GreetingsService service) {
        this.service = service;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return service.greet();
    }
}
