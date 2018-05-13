<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<fmt:bundle basename="locale">
    <fmt:message key="local.footer.rightsReserved" var="rightsReserved"/>
</fmt:bundle>


<footer class="footer-class">
    <p>${rightsReserved}</p>
    <a href="${urlPrefix}/MishaBet?command=changeLocale&locale=ru">RU</a>
    <a href="${urlPrefix}/MishaBet?command=changeLocale&locale=en">EN</a>
</footer>


