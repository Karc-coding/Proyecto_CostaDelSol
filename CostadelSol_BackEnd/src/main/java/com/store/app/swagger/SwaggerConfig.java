package com.store.app.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.store.app")).paths(PathSelectors.any()).build();

	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Costa del Sol", "Descripcion del Rest Api - Costa del Sol", "API STORE", "Terms of service",
				new Contact("Karc-G2", "www.costadelsol.com", "storecds@gmail.com"), "License of API",
				"API license URL", Collections.emptyList());
	}

}
