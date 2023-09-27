package com.Corptec.SpringBootSalesforceAndSqlIntegrator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)

                .apiInfo(apiInfo())
                .enable(true)
                .select()
               // .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.Corptec.SpringBootSalesforceAndSqlIntegrator"))

                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Corptec-SpringBoot Salesforce and SqlIntegrator")
                .description("Api Documentation for Spring Boot Salesforce and SqlIntegrator")
                .contact(new Contact("Syed Ahtesham Ullah"," ","ahtesham.syed@gmail.com"))
                .version("1.0")
                .build();

    }
}
