package com.utkarsh.inputservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class InputServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InputServiceApplication.class, args);
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Input Microservice API",
				"API Documentation for Input Microservice in Stock Market Application",
				"1.0",
				"Copyright - Utkarsh Gupta",
				new Contact("Utkarsh Gupta", "https://github.com/utkryuk", "utkryuk@gmail.com"),
				"API License",
				"https://github.com/utkryuk/socgen-stockmarket-project",
				Collections.emptyList()
		);
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/input/**"))
				.apis(RequestHandlerSelectors.basePackage("com.utkarsh"))
				.build()
				.apiInfo(apiDetails());

	}

}
