package com.rurbisservices.demo.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "kafka-app");
        SpringApplication.run(Main.class, args);
    }
}