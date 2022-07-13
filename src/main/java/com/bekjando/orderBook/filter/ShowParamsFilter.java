package com.bekjando.orderBook.filter;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class ShowParamsFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String version = request.getHeader("version");
        if(version == null || version.isEmpty()) {
            throw new IllegalArgumentException("Version is null");
        }
        System.out.println("Version" + version);
        filterChain.doFilter(request,response);
    }
}