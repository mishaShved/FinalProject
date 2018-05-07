<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/styles.css">

<fmt:bundle basename="locale">
    <fmt:message key="local.header.logout" var="logout"/>
</fmt:bundle>



<nav class="navbar navbar-default nav-class">
    <div class="container-fluid">
        <div class="navbar-header icon-class">
            <a href="/jsp/admin_page/AdminPage.jsp">
                MBET
            </a>
        </div>
    </div>
    <ul class="nav navbar-nav nav-rigth-class">
        <a href="/MishaBet?command=logout">${logout}</a></li>
    </ul>
</nav>



