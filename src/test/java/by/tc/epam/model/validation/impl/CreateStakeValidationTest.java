package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.model.validation.ValidationFactory;
import by.tc.epam.util.ConstantContainer;
import org.apache.struts.mock.MockHttpServletRequest;
import org.junit.Assert;
import org.junit.Test;

public class CreateStakeValidationTest {

    @Test
    public void testValidateEventCreateExpectedTrue() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getCreateStakeValidation();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.MONEY, "12345");


        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(true, validationResult);
    }

    @Test
    public void testValidateEventCreateExpectedFalse() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getCreateStakeValidation();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.MONEY, "-0.5");


        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(false, validationResult);
    }


}
