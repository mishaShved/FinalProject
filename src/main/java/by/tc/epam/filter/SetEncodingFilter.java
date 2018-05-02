package by.tc.epam.filter;

import by.tc.epam.util.ConstantContainer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class SetEncodingFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig = filterConfig;

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        String encoding = filterConfig.getInitParameter(ConstantContainer.CHARACTERS_ENCODING);
        request.setCharacterEncoding(encoding);


        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
