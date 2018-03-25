package by.tc.epam.model.dao;

import by.tc.epam.model.dao.exception.ConnectionPollIsEmptyException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.OddType;
import by.tc.epam.model.entity.Stacke;

import java.util.List;

public interface OddDAO {

    void createOdd(int eventId, OddType oddType, double koef, double param) throws DBLoginException, JDBCDriverNotFoundException, ConnectionPollIsEmptyException;



    void setKoef();
    void setParam();
    List<Stacke> getStakes();

}
