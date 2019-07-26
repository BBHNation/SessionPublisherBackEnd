package com.hancock.SessionPublisher.intrastructure.security;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, FilterChain filterChain)
        throws ServletException, IOException {
        System.out.println(Arrays.toString(httpServletRequest.getCookies()));
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
