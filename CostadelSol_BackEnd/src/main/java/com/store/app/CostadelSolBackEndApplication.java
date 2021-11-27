package com.store.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Log4j2
@SpringBootApplication
public class CostadelSolBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostadelSolBackEndApplication.class, args);
		log.info("--> Load Complete!!!");
	}

}
