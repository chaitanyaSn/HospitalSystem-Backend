package com.Hospital_management.ProfileMs.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests(auth->auth
                .requestMatchers(request -> "SECRET"
                        .equals(request.getHeader("X-SECRET-KEY")))
                .permitAll().anyRequest().denyAll());
        return http.build();
    }
}
