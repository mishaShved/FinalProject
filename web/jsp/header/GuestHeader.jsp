<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:bundle basename="locale">
    <fmt:message key="local.header.login" var="login"/>
    <fmt:message key="local.header.registration" var="registration"/>
</fmt:bundle>
<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-default nav-class">
    <div class="container-fluid">
        <div class="navbar-header icon-class">
            <a href="${urlPrefix}/MishaBet">
                MBET
            </a>
        </div>
        <ul class="nav navbar-nav nav-rigth-class">
            <li><a href="${urlPrefix}/jsp/LoginPage.jsp">${login}</a></li>
            <li><a href="${urlPrefix}/jsp/RegistrationPage.jsp">${registration}</a></li>
        </ul>
    </div>
</nav>
