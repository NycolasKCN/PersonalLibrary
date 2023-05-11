package br.com.nycdev.personallibrary.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("authenticate").permitAll()
//                .requestMatchers("/v1/books").permitAll()
//                .anyRequest().authenticated()
//                .and().build();
        return http.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest().permitAll()
                .and().build();
    }
}
