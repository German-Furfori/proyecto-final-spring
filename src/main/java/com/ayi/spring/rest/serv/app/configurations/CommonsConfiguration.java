package com.ayi.spring.rest.serv.app.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.ayi.spring.rest.serv.app.configurations" +
        "com.ayi.spring.rest.serv.app.services" +
        "com.ayi.spring.rest.serv.app.mappers" +
        "com.ayi.spring.rest.serv.app.repositories" +
        "com.ayi.spring.rest.serv.app.utils" })
public class CommonsConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
