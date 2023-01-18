package com.example.apirestlaptop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    //variable que recibe el valor desde properties
    @Value("${app.message}")
    String message;

    //get de prueba
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola Mundo!!"+message;
    }

    @GetMapping("/boostrap")
    public String boostrap(){ return "soy una pagina boostrap"; }
}
