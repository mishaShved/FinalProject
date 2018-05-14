package by.tc.epam.web.filter;

import by.tc.epam.model.entity.User;
import by.tc.epam.model.entity.UserType;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminPagesFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * filter blocks access to admin pages to non admins
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        User user = (User)httpRequest.getSession().getAttribute(ConstantContainer.USER);

        if (user == null || user.getUserType() != UserType.ADMIN){
            httpResponse.sendRedirect("/MishaBet");
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }


}
