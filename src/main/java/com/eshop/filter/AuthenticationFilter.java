package com.eshop.filter;

import com.eshop.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthenticationFilter implements Filter {

    private final String TOKEN_HEADER = "X-Authorization";

    @Autowired
    private TokenService tokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String tokenString = httpRequest.getHeader(TOKEN_HEADER);

        if (isValidRequest(httpRequest, tokenString)) {
            chain.doFilter(httpRequest, httpResponse);
        } else {
            httpResponse.sendError(401);
        }

    }


    private boolean isValidRequest(HttpServletRequest httpRequest, String tokenString) {
//        TokenService tokenService = new TokenService();
//        return httpRequest.getRequestURI().endsWith("/login")
//                || httpRequest.getRequestURI().endsWith("/user/register/buyer")
//                || tokenService.verifyToken(tokenString);
        return true;
    }

    @Override
    public void destroy() {
    }
}
