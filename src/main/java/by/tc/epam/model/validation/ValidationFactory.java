package by.tc.epam.model.validation;

import by.tc.epam.model.validation.impl.CreateEventValidate;
import by.tc.epam.model.validation.impl.CreateOddValidation;
import by.tc.epam.model.validation.impl.CreateStakeValidation;
import by.tc.epam.model.validation.impl.LoginValidation;
import by.tc.epam.model.validation.impl.RegistrationValidation;

public class ValidationFactory {

    private static ValidationFactory ourInstance = new ValidationFactory();
    private CreateEventValidate createEventValidate = new CreateEventValidate();
    private CreateOddValidation createOddValidation = new CreateOddValidation();
    private CreateStakeValidation createStakeValidation = new CreateStakeValidation();
    private LoginValidation loginValidation = new LoginValidation();
    private RegistrationValidation registrationValidation = new RegistrationValidation();

    public static ValidationFactory getInstance() {
        return ourInstance;
    }

    private ValidationFactory() {
    }

    public CreateEventValidate getCreateEventValidate() {
        return createEventValidate;
    }

    public CreateOddValidation getCreateOddValidation() {
        return createOddValidation;
    }

    public CreateStakeValidation getCreateStakeValidation() {
        return createStakeValidation;
    }

    public LoginValidation getLoginValidation() {
        return loginValidation;
    }

    public RegistrationValidation getRegistrationValidation() {
        return registrationValidation;
    }
}
