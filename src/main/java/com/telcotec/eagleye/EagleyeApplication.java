package com.telcotec.eagleye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc

@SpringBootApplication
public class EagleyeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EagleyeApplication.class, args);
    }

}
