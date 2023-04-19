package com.company.springproject2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    public OpenAPI openAPI(@Value("${spring.application.name}") String applicationName,
                           @Value("${spring.application.author}") String author,
                           @Value("${spring.application.version}") String version) {

        return new OpenAPI()
                .info(new Info()
                        .version(version)
                        .title(applicationName)
                        .license(new License().name(author)));
    }
}
