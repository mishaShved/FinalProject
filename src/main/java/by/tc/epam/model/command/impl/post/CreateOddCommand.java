package by.tc.epam.model.command.impl.post;

import by.tc.epam.model.command.Command;
import by.tc.epam.util.FinalStringsContainer;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.service.OddService;
import by.tc.epam.model.service.ServiceFactory;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServerOverloadException;
import by.tc.epam.model.service.exception.ServiceSQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateOddCommand implements Command{

    @Override
    public void execute(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {


        ServiceFactory factory = ServiceFactory.getInstance();
        OddService service = factory.getOddService();

        int eventId = Integer.parseInt(request.getParameter(FinalStringsContainer.EVENT_ID));
        OddType oddType = OddType.valueOf(request.getParameter(FinalStringsContainer.ODD_TYPE));
        double koef = Double.parseDouble(request.getParameter(FinalStringsContainer.KOEF));
        double param = Double.parseDouble(request.getParameter(FinalStringsContainer.PARAMETER));


        try {

            service.createOdd(eventId, oddType, koef, param);
            response.sendRedirect("/jsp/admin_page/AdminPage.jsp");

        } catch (ServerOverloadException e) {
            e.printStackTrace();
        } catch (DataSourceException e) {
            e.printStackTrace();
        } catch (ServiceSQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
