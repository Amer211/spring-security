package com.example.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for simplicity
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/home").permitAll() // Allow access to /home without authentication
                    .anyRequest().authenticated() // Require authentication for any other request
                )
                .formLogin(Customizer.withDefaults()) // Enable form-based login with default settings
                .httpBasic(Customizer.withDefaults()) // Enable HTTP Basic authentication with default settings(Postman)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Use stateless session management

                .build();

    }//filterChain






}//class
