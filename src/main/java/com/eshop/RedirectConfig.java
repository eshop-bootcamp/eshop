package com.eshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by gkoundi on 12/13/16.
 */
@Configuration
public class RedirectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    Environment environment;
    @Autowired private SecurityProperties securityProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.portMapper()
                .http(Integer.parseInt(environment.getProperty("server.http.port"))) // http port defined in yml config file
                .mapsTo(Integer.parseInt(environment.getProperty("server.port")));
        if (securityProperties.isRequireSsl()) http.requiresChannel().anyRequest().requiresSecure();
    }
}
