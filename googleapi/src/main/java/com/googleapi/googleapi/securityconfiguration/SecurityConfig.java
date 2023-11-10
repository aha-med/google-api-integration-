package com.googleapi.googleapi.securityconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf ->csrf.disable()).authorizeHttpRequests(request->request
                        .requestMatchers("/**").authenticated())
                .authorizeHttpRequests(request->request.requestMatchers("/", "/index.html").authenticated())
                .oauth2Login(Customizer.withDefaults()).logout(logout->logout.logoutSuccessUrl("/"));
        return http.build();
    }
}
