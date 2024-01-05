package com.sample.basicsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Define in memeory users
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        // in User(org.springframework.security.core.userdetails.User) Object password
        // string start with
        // {noop} means no password encoder or plain text password
        // {bcrypt} means bcrypt encoded password

        // creating user object1
        UserDetails spring = User.builder()
                .username("spring")
                .password("{noop}hello-spring")
                .roles("ADMIN")
                .build();

        // creating user object2
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}hello-john")
                .roles("MANAGER")
                .build();

        // creating user object3
        UserDetails tom = User.builder()
                .username("tom")
                .password("{noop}hello-tom")
                .roles("USER")
                .build();

        // returning in memory users
        return new InMemoryUserDetailsManager(spring, john, tom);
    }

    // Define filter for authorize request
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(config -> config
                .requestMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/manager").hasRole("MANAGER")
                .requestMatchers(HttpMethod.GET, "/user").hasRole("USER")
                .anyRequest().authenticated()

        ).formLogin(form -> form.permitAll());

        // user http basic authentication for rest apis
        // http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE
        // and/or PATCH
        // http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
