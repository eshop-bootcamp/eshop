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

        if (isValidRequest(httpRequest, tokenString)) {
            chain.doFilter(httpRequest, httpResponse);
        } else {
            httpResponse.sendError(401);
        }

    }

<<<<<<< HEAD
    private boolean isValidRequest(HttpServletRequest httpRequest, String tokenString) {
        TokenService tokenService = new TokenService();
        return httpRequest.getRequestURI().endsWith("/login")
                || httpRequest.getRequestURI().endsWith("/user/register/buyer")
                || tokenService.verifyToken(tokenString);
=======
    private boolean isValidRequest(HttpServletRequest httpRequest, String tokenString, TokenService tokenService) {
//        return httpRequest.getRequestURI().endsWith("/login")
//                || httpRequest.getRequestURI().endsWith("/user/register")
//                || tokenService.verifyToken(tokenString);

        return true;
>>>>>>> db5b2bfb30149fee58e3a64908ab483c9b832e4e
    }

    @Override
    public void destroy() {
    }
}
