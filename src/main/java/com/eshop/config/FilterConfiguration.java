package com.eshop.config;

import com.eshop.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfiguration {

    @Bean
    FilterRegistrationBean registerAuthFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new AuthenticationFilter());
        return registrationBean;
    }

}
