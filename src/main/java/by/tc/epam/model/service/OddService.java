package by.tc.epam.model.service;

import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.service.exception.DBWorkingException;
import by.tc.epam.model.service.exception.ServerOverloadException;

public interface OddService {

    void createOdd(int eventId, OddType oddType, double koef, double param)
            throws ServerOverloadException, DBWorkingException;

}
