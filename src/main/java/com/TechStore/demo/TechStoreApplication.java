package com.TechStore.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.TechStore.Services",
    "com.TechStore.models",
    "com.TechStore.Repository",
    "com.TechStore.Controllers"
})
@EnableJpaRepositories(basePackages = "com.TechStore.Repository")
@EntityScan(basePackages = "com.TechStore.models")
public class TechStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechStoreApplication.class, args);
    }
}