package com.puribot.ai_core.infrastructure.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/api/analyze/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                            .anyRequest().authenticated()
                    )
                    .httpBasic(withDefaults())
                    .formLogin(withDefaults());

            return http.build(); // Agora o vermelho vai sumir!
        }
    }

