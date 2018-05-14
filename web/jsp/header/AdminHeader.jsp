<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<fmt:bundle basename="locale">
    <fmt:message key="local.header.logout" var="logout"/>
</fmt:bundle>

<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-default nav-class">
    <div class="container-fluid">
        <div class="navbar-header icon-class">
            <a href="${urlPrefix}/jsp/admin_page/AdminPage.jsp">
                MBET
            </a>
        </div>
    </div>
    <ul class="nav navbar-nav nav-rigth-class">
        <a href="${urlPrefix}/MishaBet?command=logout">${logout}</a></li>
    </ul>
</nav>



