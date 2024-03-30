package org.example.alias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AliasApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AliasApplication.class, args);
    }

    public void addViewController(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
    }

}
