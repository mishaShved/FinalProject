package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpServletRequest;

public class CreateStakeValidation implements Validation{

    @Override
    public boolean validate(HttpServletRequest request) {

        double money =  Double.parseDouble(request.getParameter(ConstantContainer.MONEY));

        return money > ConstantContainer.MIN_STAKE_SUM;
    }

}
