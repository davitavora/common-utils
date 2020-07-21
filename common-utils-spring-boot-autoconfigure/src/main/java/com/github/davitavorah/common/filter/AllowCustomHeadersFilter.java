package com.github.davitavorah.common.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.String.format;
import static org.springframework.http.HttpHeaders.*;

public class AllowCustomHeadersFilter implements Filter {

    private static final String CONTENT_RANGE = "Content-Range";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var response = (HttpServletResponse) servletResponse;
        response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, CONTENT_TYPE);
        response.setHeader(ACCESS_CONTROL_EXPOSE_HEADERS, format("%s, %s, %s", CONTENT_RANGE, LOCATION, CONTENT_DISPOSITION));

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
