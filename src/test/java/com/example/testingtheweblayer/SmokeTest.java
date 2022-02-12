package com.example.testingtheweblayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}