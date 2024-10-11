package org.example.ge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class GeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeApplication.class, args);
    }

}
