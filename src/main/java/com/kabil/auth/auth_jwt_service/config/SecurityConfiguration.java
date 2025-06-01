package com.kabil.auth.auth_jwt_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions().disable()) // For H2 console
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/accounts/register").permitAll()
                .requestMatchers("/api/v1/accounts/login").permitAll()
                .requestMatchers("/api/v1/accounts/hello").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()

                
            );
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }
}
