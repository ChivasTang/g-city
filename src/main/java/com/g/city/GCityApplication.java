package com.g.city;

import com.g.city.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"com.g.city"})
@EnableConfigurationProperties(RsaKeyProperties.class)
public class GCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(GCityApplication.class, args);
    }

}
