package com.eshop.auth.config;

import com.eshop.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by akshaybansod on 12/14/16.
 */
@Configuration
public class WebConfiguration {

    @Bean
    FilterRegistrationBean registerAuthFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new AuthenticationFilter());
        return registrationBean;
    }

}
