package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AgentServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(AgentServiceMain.class, args);
    }
}