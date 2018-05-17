package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

public class CreateEventValidate implements Validation{

    /**
     *  validation for create event
     * @param request
     * @return
     */
    @Override
    public boolean validate(HttpServletRequest request) {

        String team1RU = request.getParameter(ConstantContainer.TEAM1RU);
        String team2RU = request.getParameter(ConstantContainer.TEAM2RU);
        String team1EN = request.getParameter(ConstantContainer.TEAM1EN);
        String team2EN = request.getParameter(ConstantContainer.TEAM2EN);

        return !(team1RU.isEmpty() || team2RU.isEmpty() || team1EN.isEmpty() || team2EN.isEmpty() );
    }
}
