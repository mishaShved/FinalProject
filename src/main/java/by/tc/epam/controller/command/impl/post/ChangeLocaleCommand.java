package by.tc.epam.controller.command.impl.post;

import by.tc.epam.controller.command.Command;
import by.tc.epam.controller.command.impl.go_to_page.GoToStartPage;
import by.tc.epam.util.ConstantContainer;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

public class ChangeLocaleCommand implements Command{

    private static final Logger log = Logger.getLogger(GoToStartPage.class);

    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Change user locale
     *
     */
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {


        String newLocale = request.getParameter(ConstantContainer.LOCALE);

        request.getSession().setAttribute(ConstantContainer.LOCALE, newLocale);
        Config.set(request.getSession(), Config.FMT_LOCALE, newLocale);
        try {
            response.sendRedirect(urlPrefix + ConstantContainer.DEFAULT_APPLICATION_URL);
        } catch (IOException e) {
            log.error("File path error", e);
        }

    }


}
