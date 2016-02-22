package com.palvair.spring.form.validation.thymeleaf.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by widdy on 07/02/2016.
 */
@SpringBootApplication(scanBasePackages = "com.palvair.spring.form.validation.thymeleaf.controller")
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
