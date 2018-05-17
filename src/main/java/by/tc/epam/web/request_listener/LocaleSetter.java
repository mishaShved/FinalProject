package by.tc.epam.web.request_listener;

import by.tc.epam.util.ConstantContainer;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class LocaleSetter implements ServletRequestListener {

    /**
     * listener set default locale to users
     * @param sre
     */

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        Locale userLocale = request.getLocale();
        if(request.getSession(true).getAttribute(ConstantContainer.LOCALE) != null){
            return;
        }

        if(userLocale.getLanguage().equals(ConstantContainer.RU_LOCALE)){
            request.getSession().setAttribute(ConstantContainer.LOCALE, ConstantContainer.RU_LOCALE);
        }else{
            request.getSession().setAttribute(ConstantContainer.LOCALE, ConstantContainer.DEFAULT_LOCALE);
        }
    }
}
