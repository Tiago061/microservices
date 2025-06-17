package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //Necessario em toda aplicacao Spring boot chamar o metodo run da classe SpringApplication
        //Configura uma aplicacao Spring Basica, criando todos os beans no projeto
        SpringApplication.run(Main.class, args);
    }
}