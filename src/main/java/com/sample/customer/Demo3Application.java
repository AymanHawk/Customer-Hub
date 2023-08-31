package com.sample.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController

public class Demo3Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo3Application.class, args);
	}

//	@GetMapping("/")// indicates RESTful endpoints
//	public List<String> hello(){
//		return List.of("Hello", "World");
//	}

}
