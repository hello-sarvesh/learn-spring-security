package com.sample.basicsecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // add support for JDBC ... no more hardcoded users :-)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user/member by username / m_id
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select m_id,pwd,active from members where m_id =?");

        // define query to retrieve a authorities/roles by username / m_id
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select m_id,roles from roles where m_id = ?");

        return jdbcUserDetailsManager;
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
