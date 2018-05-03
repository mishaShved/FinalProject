<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../../css/styles.css">


<fmt:bundle basename="locale">
    <fmt:message key="local.footer.rightsReserved" var="rightsReserved"/>
</fmt:bundle>


<html>
<head>
    <title>Title</title>
</head>
<body>

    <footer class="footer-class">
        <p>${rightsReserved}</p>
        <a href="/MishaBet?command=changeLocale&locale=ru">RU</a>
        <a href="/MishaBet?command=changeLocale&locale=en">EN</a>
    </footer>

</body>
</html>
