package by.tc.epam.web.filter;

import by.tc.epam.util.ConstantContainer;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import java.io.IOException;

public class SetEncodingFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig = filterConfig;

    }

    /**
     * filter change encoding
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
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
