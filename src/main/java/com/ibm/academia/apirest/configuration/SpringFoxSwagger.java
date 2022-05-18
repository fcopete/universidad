package com.ibm.academia.apirest.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;




//@Configuration
//@EnableSwagger2
public class SpringFoxSwagger {
	@Bean
    public Docket getDocket()
	{
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ibm.academia.apirest.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() 
    {
        return new ApiInfo(
                "Universidad Backend API",
                "API para el manejo de Universidad",
                "V1",
                "Terminos del servicio",
                new Contact("Francisco Copete", "www.google.com", "francisco.copete@hotmail.com"),
                "Licencia de API", "API licencia url", Collections.emptyList()
        );
    } 
}