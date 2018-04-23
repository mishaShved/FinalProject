package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

public class CreateEventValidate implements Validation{


    @Override
    public boolean validate(HttpServletRequest request) {

        String team1 = request.getParameter(ConstantContainer.TEAM1);
        String team2 = request.getParameter(ConstantContainer.TEAM2);

        return !(team1.isEmpty() || team2.isEmpty());
    }
}
