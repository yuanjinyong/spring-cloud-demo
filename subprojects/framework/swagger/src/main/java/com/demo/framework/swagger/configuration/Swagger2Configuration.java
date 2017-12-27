/**
 * 
 */
package com.demo.framework.swagger.configuration;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 袁进勇
 *
 */
@EnableSwagger2
@Configuration
@ConditionalOnProperty(prefix = "swagger", name = "enable", havingValue = "true")
public class Swagger2Configuration {
    @Value("${swagger.base-package:#{null}}")
    private String basePackage;
    @Value("${spring.application.name:#{null}}")
    private String applicationName;
    @Value("${spring.application.version:1.0.0}")
    private String applicationVersion;

    @Bean
    public Docket restfullApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.apiInfo(new ApiInfoBuilder().title(applicationName).version(applicationVersion).build());

        if (basePackage == null || basePackage.trim().length() == 0) {
            docket.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
        } else {
            docket.select().apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any()).build();
        }

        docket.directModelSubstitute(Timestamp.class, Long.class);

        return docket;
    }
}
