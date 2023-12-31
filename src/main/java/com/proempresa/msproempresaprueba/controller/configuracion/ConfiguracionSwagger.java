package com.proempresa.msproempresaprueba.controller.configuracion;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class ConfiguracionSwagger {
//    private ApiKey apiKey(){
//      return new ApiKey("JWT","Authorization","header");
//   }
//
//  @Bean
//  public Docket api(){
//      return new Docket(DocumentationType.SWAGGER_2)
//              .securitySchemes(Arrays.asList(apiKey()))
//              .select()
//              .apis(RequestHandlerSelectors.basePackage("com.proempresa.msproempresaprueba.controller"))
//              .build();
//  }
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.proempresa.msproempresaprueba.controller"))
				.paths(PathSelectors.any())
				.build()
				;
	}
	
}
