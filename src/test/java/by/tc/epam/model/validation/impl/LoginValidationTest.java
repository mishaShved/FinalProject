package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.model.validation.ValidationFactory;
import by.tc.epam.util.ConstantContainer;
import org.apache.struts.mock.MockHttpServletRequest;
import org.junit.Assert;
import org.junit.Test;

public class LoginValidationTest {

    @Test
    public void testValidateEventCreateExpectedTrue() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getLoginValidation();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.PASSWORD, "12345");
        mockRequest.addParameter(ConstantContainer.ID, "60");

        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(true, validationResult);
    }

    @Test
    public void testValidateEventCreateExpectedFalse() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getLoginValidation();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.PASSWORD, "12345");
        mockRequest.addParameter(ConstantContainer.ID, "-500");

        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(false, validationResult);
    }

    @Test
    public void testValidateEventCreateExpectedFalse2() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getLoginValidation();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.PASSWORD, "qwe");
        mockRequest.addParameter(ConstantContainer.ID, "35");

        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(false, validationResult);
    }

}
