package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

public class LoginValidation implements Validation {
    @Override
    public boolean validate(HttpServletRequest request) {


        int id = Integer.parseInt(request.getParameter(ConstantContainer.ID));
        String password = request.getParameter(ConstantContainer.PASSWORD);

        return !(id < ConstantContainer.MIN_ACCOUNT_NUMBER ||
                password.length() < ConstantContainer.MIN_LENGTH_PASSWORD ||
                password.length() > ConstantContainer.MAX_LENGTH_PASSWORD);
    }
}
