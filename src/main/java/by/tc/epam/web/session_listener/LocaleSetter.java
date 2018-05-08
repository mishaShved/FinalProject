package by.tc.epam.web.session_listener;

import by.tc.epam.util.ConstantContainer;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LocaleSetter implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute(ConstantContainer.LOCALE, ConstantContainer.DEFAULT_LOCALE);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
