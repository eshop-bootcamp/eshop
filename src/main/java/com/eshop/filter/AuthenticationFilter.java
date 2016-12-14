package com.eshop.filter;

import com.eshop.services.implementation.TokenServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String token = httpRequest.getHeader("auth-header");
        TokenServiceImpl tokenServiceImpl = new TokenServiceImpl();
        System.out.println(token);
        if (httpRequest.getRequestURI().endsWith("/login") || tokenServiceImpl.verifyToken(token)) {
            chain.doFilter(httpRequest, httpResponse);
        } else {
            httpResponse.sendError(401);
        }

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
