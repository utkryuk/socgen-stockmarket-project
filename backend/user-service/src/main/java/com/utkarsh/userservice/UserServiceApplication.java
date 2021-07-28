package com.utkarsh.userservice;

import com.utkarsh.userservice.entity.User;
import com.utkarsh.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserServiceApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User admin = new User("admin",
				passwordEncoder.encode("password"),
				"ryukutk@gmail.com",
				"9999888812",
				"ADMIN",
				true);
		userRepository.save(admin);
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"User Microservice API",
				"API Documentation for User Microservice in Stock Market Application",
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
				.paths(PathSelectors.ant("/user"))
				.apis(RequestHandlerSelectors.basePackage("com.utkarsh"))
				.build()
				.apiInfo(apiDetails());

	}

}
