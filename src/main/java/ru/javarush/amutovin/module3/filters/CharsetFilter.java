package ru.javarush.amutovin.module3.filters;

import javax.servlet.*;
import java.io.IOException;


public class CharsetFilter implements Filter {

    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       encoding = filterConfig.getInitParameter("requestEncoding");
        if (null == encoding) {
            encoding = "UTF-8";
            System.out.println("=============coding not set in request================");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (null == servletRequest.getCharacterEncoding()) {
            servletRequest.setCharacterEncoding(encoding);
        }
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
