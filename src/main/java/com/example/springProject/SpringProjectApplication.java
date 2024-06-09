package com.example.springProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@GetMapping
	public List<String> hello(){
		return List.of("Hello", "World");
	}


}
