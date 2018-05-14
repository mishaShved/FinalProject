package by.tc.epam.model.service.impl;

import by.tc.epam.model.dao.DAOFactory;
import by.tc.epam.model.dao.EventDAO;
import by.tc.epam.model.dao.exception.ConnectionPoolException;
import by.tc.epam.model.dao.exception.DAOSQLException;
import by.tc.epam.model.dao.exception.DBLoginException;
import by.tc.epam.model.dao.exception.JDBCDriverNotFoundException;
import by.tc.epam.model.entity.BukmakerDate;
import by.tc.epam.model.entity.EntityBuilder;
import by.tc.epam.model.entity.Event;
import by.tc.epam.model.entity.Sport;
import by.tc.epam.model.service.EventService;
import by.tc.epam.model.service.exception.DataSourceException;
import by.tc.epam.model.service.exception.ServiceSQLException;
import java.util.List;

public class EventServiceImpl implements EventService{

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final EventDAO eventDAO = daoFactory.getEventDAO();

    /**
     * prepare parameters for invoke dao
     * @param date
     * @param time
     * @param team1RU
     * @param team2RU
     * @param team1EN
     * @param team2EN
     * @param sportType
     * @throws ServiceSQLException
     * @throws DataSourceException
     */
    @Override
    public void createEvent(String date, String time, String team1RU,
                            String team2RU, String team1EN, String team2EN, Sport sportType)
            throws ServiceSQLException, DataSourceException {

        EntityBuilder builder = EntityBuilder.getInstance();
        BukmakerDate fullDate = builder.createDate();

        fullDate.setDate(date);
        fullDate.setTime(time);

        try {
            eventDAO.createEvent(fullDate.getFullDate(), team1RU, team2RU, team1EN, team2EN, sportType);
        } catch ( ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

    }

    /**
     *  prepare parameters for invoke dao
     * @param locale
     * @return
     * @throws DataSourceException
     * @throws ServiceSQLException
     */
    @Override
    public List<Event> getAllEvents(String locale)
            throws DataSourceException, ServiceSQLException {

        List<Event> allEvents;

        try {

            allEvents =  eventDAO.getAllEvents(locale);

        } catch ( ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return allEvents;
    }

    /**
     *  prepare parameters for invoke dao
     * @param sport
     * @param locale
     * @return
     * @throws ServiceSQLException
     * @throws DataSourceException
     */
    @Override
    public List<Event> getEventsBySport(Sport sport, String locale)
            throws ServiceSQLException, DataSourceException{

        List<Event> partEvents;

        try {
            partEvents = eventDAO.getEventsBySport(sport, locale);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }catch ( ConnectionPoolException e) {
            throw new DataSourceException(e);
        }

        return partEvents;


    }

    /**
     *  prepare parameters for invoke dao
     * @param locale
     * @return
     * @throws DataSourceException
     * @throws ServiceSQLException
     */
    @Override
    public List<Event> getEventsForAddOdd(String locale)
            throws DataSourceException, ServiceSQLException {

        List<Event> allEvents;

        try {

            allEvents =  eventDAO.getEventsForAddOdd(locale);

        } catch ( ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

        return allEvents;
    }

    /**
     *  prepare parameters for invoke dao
     * @param eventId
     * @param score1
     * @param score2
     * @throws ServiceSQLException
     * @throws DataSourceException
     */
    @Override
    public void setScore(int eventId, int score1, int score2)
            throws ServiceSQLException, DataSourceException {

        try {
            eventDAO.setScore(eventId, score1, score2);
        } catch ( ConnectionPoolException e) {
            throw new DataSourceException(e);
        } catch (DAOSQLException e) {
            throw new ServiceSQLException(e);
        }

    }

}
