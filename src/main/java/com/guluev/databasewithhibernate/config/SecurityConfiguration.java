package com.guluev.databasewithhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.formLogin().and().
                authorizeHttpRequests().requestMatchers("/all").permitAll().
                and().
                authorizeHttpRequests().requestMatchers("/add").hasAuthority("add").
                and().
                authorizeHttpRequests().requestMatchers("/delete").hasAuthority("delete").
                anyRequest().authenticated();
        return security.build();

    }

    @Bean
    public UserDetailsService userDetailsManager() {
        List<UserDetails> users = List.of(
                User.builder().
                        username("Ivan").
                        password(bCryptPasswordEncoder().encode("password")).
                        roles("READ").
                        build(),
                User.builder()
                        .username("Georgiy")
                        .password(bCryptPasswordEncoder().encode("password"))
                        .roles("READ", "WRITE", "DELETE")
                        .build(),
                User.builder()
                        .username("Eva")
                        .password(bCryptPasswordEncoder().encode("password"))
                        .roles("DELETE")
                        .build()

        );
        return new InMemoryUserDetailsManager(users);
    }

}
