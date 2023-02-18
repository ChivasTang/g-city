package com.g.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.g.city"})
public class GCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(GCityApplication.class, args);
    }

}
