package by.tc.epam.model.validation;

import javax.servlet.http.HttpServletRequest;

public interface Validation {

    boolean validate(HttpServletRequest request);

}
