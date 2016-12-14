package com.eshop.filter;

import com.eshop.services.TokenService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthenticationFilter implements Filter {

    private final String TOKEN_HEADER = "X-Authorization";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String tokenString = httpRequest.getHeader(TOKEN_HEADER);
        TokenService tokenService = new TokenService();

        if (httpRequest.getRequestURI().endsWith("/login") || tokenService.verifyToken(tokenString)) {
            chain.doFilter(httpRequest, httpResponse);
        } else {
            httpResponse.sendError(401);
        }

    }

    @Override
    public void destroy() {
    }
}
