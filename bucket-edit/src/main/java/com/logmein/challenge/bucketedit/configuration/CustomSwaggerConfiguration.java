package com.logmein.challenge.bucketedit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class CustomSwaggerConfiguration {
    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.logmein.challenge.bucketedit"))
                .paths(PathSelectors.regex("/bucket.*"))
                .build()
                .apiInfo(apiInformation());
    }

    private ApiInfo apiInformation(){
        return new ApiInfo(
                "Bucket Edit API",
                "This api helps to manipulate the items in a bucket.",
                "1.0",
                "Free to use.",
                new springfox.documentation.service.Contact("Anuj Kumar",null,"anuj0412@gmail.com"),
                null,
                null,
                Collections.emptyList());
    }

}
