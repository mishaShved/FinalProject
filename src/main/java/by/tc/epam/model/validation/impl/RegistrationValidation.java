package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation implements Validation{
    /**
     * validation for registation
     * @param request
     * @return
     */
    @Override
    public boolean validate(HttpServletRequest request) {


        String name = request.getParameter(ConstantContainer.NAME);
        String password = request.getParameter(ConstantContainer.PASSWORD);
        String email = request.getParameter(ConstantContainer.EMAIL);

        Pattern p = Pattern.compile(ConstantContainer.EMAIL_REG_EXP);
        Matcher m = p.matcher(email);


        return !(name.length() < ConstantContainer.MIN_NAME_LENGTH ||
                !m.matches() ||
                password.length() < ConstantContainer.MIN_LENGTH_PASSWORD ||
                password.length() > ConstantContainer.MAX_LENGTH_PASSWORD);


    }
}
