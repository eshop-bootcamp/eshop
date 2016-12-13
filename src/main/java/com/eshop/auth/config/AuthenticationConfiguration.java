package com.eshop.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class AuthenticationConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    Environment environment;

    @Autowired private SecurityProperties securityProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.portMapper()
                .http(Integer.parseInt(environment.getProperty("server.http.port")))
                .mapsTo(Integer.parseInt(environment.getProperty("server.port")));
        if (securityProperties.isRequireSsl()) http.requiresChannel().anyRequest().requiresSecure();

        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic().and()
//                .authorizeRequests().antMatchers("/user").permitAll()
//                .and()
                .csrf().disable()
        ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("username").password("password").roles("USER");
    }
}
