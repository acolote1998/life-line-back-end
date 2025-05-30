package com.akiacevedo.life_line_back_end.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class DaySecurity {

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        http
                .csrf((crsf -> crsf.disable()))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/days/byUser").authenticated()
                        .requestMatchers("/days/byUser/*").authenticated()
                        .requestMatchers(HttpMethod.POST, "/days").authenticated()
                )
                .cors(withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));
        return http.build();
    }
}
