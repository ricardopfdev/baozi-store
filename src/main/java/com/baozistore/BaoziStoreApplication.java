package com.baozistore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta é a classe principal do projeto.
// A anotação @SpringBootApplication faz o Spring Boot iniciar tudo automaticamente.
@SpringBootApplication
public class BaoziStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaoziStoreApplication.class, args);
    }

}
