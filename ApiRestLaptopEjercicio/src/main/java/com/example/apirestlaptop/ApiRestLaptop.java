package com.example.apirestlaptop;

import com.example.apirestlaptop.controller.LaptopController;
import com.example.apirestlaptop.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApiRestLaptop {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ApiRestLaptop.class, args);
		LaptopController laptopController = new LaptopController(context.getBean(LaptopRepository.class));
		laptopController.datosPrueba();

	}

}
