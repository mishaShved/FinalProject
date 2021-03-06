package by.tc.epam.model.validation.impl;

import by.tc.epam.model.validation.Validation;
import by.tc.epam.model.validation.ValidationFactory;
import by.tc.epam.util.ConstantContainer;
import org.apache.struts.mock.MockHttpServletRequest;
import org.junit.Assert;
import org.junit.Test;


public class CreateEventValidationTest {

    @Test
    public void testValidateEventCreateExpectedTrue() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getCreateEventValidate();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.TEAM1RU, "qwe");
        mockRequest.addParameter(ConstantContainer.TEAM2RU, "qwe");
        mockRequest.addParameter(ConstantContainer.TEAM1EN, "qwe");
        mockRequest.addParameter(ConstantContainer.TEAM2EN, "qwe");

        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(true, validationResult);
    }

    @Test
    public void testValidateEventCreateExpectedFalse() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getCreateEventValidate();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.TEAM1RU, "");
        mockRequest.addParameter(ConstantContainer.TEAM2RU, "qwe");
        mockRequest.addParameter(ConstantContainer.TEAM1EN, "qwe");
        mockRequest.addParameter(ConstantContainer.TEAM2EN, "qwe");

        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(false, validationResult);
    }

    @Test
    public void testValidateEventCreateExpectedFalse2() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getCreateEventValidate();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.TEAM1, "");
        mockRequest.addParameter(ConstantContainer.TEAM2, "");
        mockRequest.addParameter(ConstantContainer.TEAM1EN, "");
        mockRequest.addParameter(ConstantContainer.TEAM2EN, "");

        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(false, validationResult);
    }

    @Test
    public void testValidateEventCreateExpectedFalse3() {

        ValidationFactory factory = ValidationFactory.getInstance();
        Validation validation = factory.getCreateEventValidate();

        MockHttpServletRequest mockRequest = new MockHttpServletRequest();

        mockRequest.addParameter(ConstantContainer.TEAM1, "");

        boolean validationResult = validation.validate(mockRequest);

        Assert.assertEquals(false, validationResult);
    }

}
