package com.utkarsh.inputservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InputServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InputServiceApplication.class, args);
	}

}
