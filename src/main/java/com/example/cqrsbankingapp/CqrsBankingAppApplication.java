package com.example.cqrsbankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CqrsBankingAppApplication {

    public static void main(
            final String[] args
    ) {
        SpringApplication.run(CqrsBankingAppApplication.class, args);
    }

}
