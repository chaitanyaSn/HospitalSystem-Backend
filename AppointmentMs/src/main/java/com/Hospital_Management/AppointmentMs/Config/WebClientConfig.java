package com.Hospital_Management.AppointmentMs.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {

        return WebClient.builder().defaultHeader("X-SECRET-KEY", "SECRET");
    }
}
