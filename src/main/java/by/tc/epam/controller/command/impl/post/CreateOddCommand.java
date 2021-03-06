package by.tc.epam.controller.command.impl.post;

import by.tc.epam.controller.command.Command;
import by.tc.epam.model.validation.Validation;
import by.tc.epam.model.validation.ValidationFactory;
import by.tc.epam.util.ConstantContainer;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateOddCommand implements Command{

    private static final Logger log = Logger.getLogger(CreateOddCommand.class);

    /**
     *
     * @param servlet
     * @param request
     * @param response
     * @param urlPrefix
     *
     * Command create odd
     *
     */
    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request,
                        HttpServletResponse response, String urlPrefix) {

        ValidationFactory validationFactory = ValidationFactory.getInstance();
        Validation validation = validationFactory.getCreateOddValidation();

        if(validation.validate(request)) {

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            OddService service = serviceFactory.getOddService();

            int eventId = Integer.parseInt(request.getParameter(ConstantContainer.EVENT_ID));
            OddType oddType = OddType.valueOf(request.getParameter(ConstantContainer.ODD_TYPE));
            double koef = Double.parseDouble(request.getParameter(ConstantContainer.KOEF));
            double param = Double.parseDouble(request.getParameter(ConstantContainer.PARAMETER));


            try {

                service.createOdd(eventId, oddType, koef, param);

                request.getSession().setAttribute(ConstantContainer.IS_UPDATE, true);
                response.sendRedirect(urlPrefix + ConstantContainer.ADMIN_PAGE);

            } catch (DataSourceException e) {
                log.error("Problems with data source", e);
            } catch (ServiceSQLException e) {
                log.error("SQL error", e);
            } catch (IOException e) {
                log.error("Error in pages path", e);
            }

        }else{
            try {
                response.sendRedirect(urlPrefix + ConstantContainer.BAD_REQUEST_PAGE);
            } catch (IOException e) {
                log.error("Error page not found " + e);
            }
        }

    }
}
