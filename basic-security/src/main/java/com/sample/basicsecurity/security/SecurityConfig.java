package com.sample.basicsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    // Define in memeory users
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        // in User(org.springframework.security.core.userdetails.User) Object password string start with
        // {noop} means no password encoder or plain text password
        // {bcrypt} means bcrypt encoded password


        // creating user object1
        UserDetails spring = User.builder()
                .username("spring")
                .password("{noop}hello-spring")
                .build();

        // creating user object2
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}hello-john")
                .build();

        // returning in memory users
        return new InMemoryUserDetailsManager(spring, john);
    }
}
