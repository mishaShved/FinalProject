package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

public class CreateOddValidation implements Validation{

    @Override
    public boolean validate(HttpServletRequest request) {

        double koef = Double.parseDouble(request.getParameter(ConstantContainer.KOEF));
        double param = Double.parseDouble(request.getParameter(ConstantContainer.PARAMETER));

        return koef < ConstantContainer.MIN_COEF || param % 0.5 != 0;
    }
}
