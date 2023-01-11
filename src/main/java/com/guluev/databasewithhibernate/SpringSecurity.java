package com.guluev.databasewithhibernate;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringSecurity {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(SpringSecurity.class, args);

    }
}
