package com.example.eventbooking.event_booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .disable()
                //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            )
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/user/**").authenticated()
                .anyRequest().permitAll() // Autorise toutes les autres requêtes
            )
            .httpBasic(basic -> basic
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                })
            );

        return http.build();
    }


    /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) // CSRF avec cookie
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/user/**").authenticated() // Nécessite une authentification pour /user
                .anyRequest().permitAll() // Autoriser toutes les autres requêtes
            )
            .httpBasic(basic -> basic
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        })) // Utiliser l'authentification basique
            /* .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Création de session si nécessaire
                .maximumSessions(1) // Limiter à une session par utilisateur
                .expiredUrl("/login?expired=true")) // URL après expiration de la session
            .requiresChannel(channel -> channel
                .anyRequest().requiresSecure()); // Exiger HTTPS */

        /*return http.build(); // Retourne la configuration construite
    } */
}