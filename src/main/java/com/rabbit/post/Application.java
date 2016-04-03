package com.rabbit.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@IntegrationComponentScan
@EnableAutoConfiguration
@Configuration
@EnableIntegration
@PropertySources(value = {
        @PropertySource("classpath:application.properties")
})
@ComponentScan(
        value = "com.rabbit.post",
        basePackages = { "com.rabbit.post"}
)
@ImportResource("classpath:spring-integration-context.xml")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
