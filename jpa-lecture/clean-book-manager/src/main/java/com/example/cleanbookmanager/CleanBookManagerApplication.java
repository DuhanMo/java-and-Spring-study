package com.example.cleanbookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CleanBookManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanBookManagerApplication.class, args);
    }

}
