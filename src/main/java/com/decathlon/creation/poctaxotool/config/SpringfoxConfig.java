package com.decathlon.creation.poctaxotool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringfoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30).groupName("Taxonomy").select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.decathlon.creation.poctaxotool"))
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("DECATHLON CREATION - Taxonomy tool POC").description("API to create some taxo items for DDFS").build();
    }
}