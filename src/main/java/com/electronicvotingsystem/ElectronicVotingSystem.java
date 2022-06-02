package com.electronicvotingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ElectronicVotingSystem {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicVotingSystem.class, args);
		
	}
//	
//	@Bean 
//	public Docket productApi() { 
//		return new Docket(DocumentationType.SWAGGER_2).select() .apis(RequestHandlerSelectors.basePackage("com.electronicvotingsystem.controller")).build(); }

	@Bean
	public Docket swaggerConfiguration() {

	return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
	.apis(RequestHandlerSelectors.basePackage("com.electronicvotingsystem.controller")).build().apiInfo(apiInfo());


	}
	private ApiInfo apiInfo() {

	return new ApiInfoBuilder().title("electronicvotingsystem").description("electronicvotingsystem")
	.termsOfServiceUrl("http://godknows.com")
	.licenseUrl("surya@gmail.com").version("1.0").build();
	}
}