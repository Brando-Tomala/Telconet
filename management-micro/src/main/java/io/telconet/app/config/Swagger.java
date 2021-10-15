package io.telconet.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 12/10/2021
 */

@Configuration
@EnableSwagger2
public class Swagger {
    private static final Set<String> CONSUMES_PRODUCES= new HashSet<>(List.of("application/json"));

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("io.telconet.app"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo())
                .consumes(CONSUMES_PRODUCES)
                .produces(CONSUMES_PRODUCES);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Telconet: API REST MANAGEMENT",
                "API REST Management de telconet", "1.0", "Terms of Service",
                new Contact("Brando Tomala", "https://github.com/Brando-Tomala","brando.tomalav@gmail.com"),
                "Apache License Version 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html", Collections.emptyList());
    }
}
