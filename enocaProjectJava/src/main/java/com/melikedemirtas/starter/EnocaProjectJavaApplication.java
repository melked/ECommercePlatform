package com.melikedemirtas.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.melikedemirtas"})
@EntityScan(basePackages = { "com.melikedemirtas"})
@EnableJpaRepositories(basePackages = { "com.melikedemirtas"})
public class EnocaProjectJavaApplication {

	public static void main(String[] args ){
		SpringApplication.run(EnocaProjectJavaApplication.class, args);
		
	}
}