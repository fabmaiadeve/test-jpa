package com.fabdev.testjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJpaApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {return "Olá Mundo!";}

}
