package com.user;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableEncryptableProperties
@OpenAPIDefinition(
		info=@Info(
				
				title="Spring Boot rest api documentation",
				description="Spring boot rest api documentaion",
				version="v1.0",
				contact=@Contact(
						name="Siddharth",
						email="siddharth.singh0701@gmail.com",
						url="https://siddhartsingh.netlify.app/"
						),
				license = @License(
						name="Apache 2.0",
						url="#"
						)
				),
		externalDocs = @ExternalDocumentation(
				description="Spring boot user management documentaion",
				url="#"
				)
		)
public class UserServiceApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	

}
