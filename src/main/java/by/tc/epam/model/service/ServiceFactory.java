package by.tc.epam.model.service;

import by.tc.epam.model.service.impl.EventServiceImpl;
import by.tc.epam.model.service.impl.OddServiceImpl;
import by.tc.epam.model.service.impl.StakeServiceImpl;
import by.tc.epam.model.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory ourInstance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final EventService eventService = new EventServiceImpl();
    private final OddService oddService = new OddServiceImpl();
    private final StakeService stackeService = new StakeServiceImpl();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public OddService getOddService() {
        return oddService;
    }

    public StakeService getStackeService() {
        return stackeService;
    }
}
