package com.guluev.databasewithhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
@EnableMethodSecurity()
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsManager(BCryptPasswordEncoder bCryptPasswordEncoder) {

        List<UserDetails> users = List.of(
                User.builder().
                        username("user").
                        password(bCryptPasswordEncoder.encode("password")).
                        roles("READ").
                        build(),
                User.builder()
                        .username("admin")
                        .password(bCryptPasswordEncoder.encode("password"))
                        .roles("READ", "WRITE", "DELETE")
                        .build(),
                User.builder()
                        .username("manager")
                        .password(bCryptPasswordEncoder.encode("password"))
                        .roles("DELETE")
                        .build()

        );
        return new InMemoryUserDetailsManager(users);
    }

}
