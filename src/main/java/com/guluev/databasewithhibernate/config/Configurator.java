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
public class Configurator {
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
                        username("admin").
                        password(bCryptPasswordEncoder().encode("password")).
                        authorities("add", "delete").
                        build(),
                User.builder()
                        .username("user")
                        .password(bCryptPasswordEncoder().encode("password"))
                        .authorities("add")
                        .build()
        );
        return new InMemoryUserDetailsManager(users);
    }

}
