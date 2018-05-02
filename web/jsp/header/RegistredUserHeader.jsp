<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/styles.css">


<fmt:bundle basename="locale">
    <fmt:message key="local.header.balance" var="balance"/>
    <fmt:message key="local.header.accountNumber" var="account"/>
    <fmt:message key="local.header.logout" var="logout"/>
    <fmt:message key="local.header.settings" var="settings"/>
    <fmt:message key="local.header.accountHistory" var="history"/>
    <fmt:message key="local.header.depositWithdraw" var="depositWithdraw"/>
</fmt:bundle>


<html>
<head>
    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-default nav-class">
    <div class="container-fluid">
        <div class="navbar-header icon-class">
            <a href="/MishaBet">
                MBET
            </a>
        </div>
        <ul class="nav navbar-nav nav-rigth-class">
            <li><a href="#">${settings}</a></li>
            <li>
                <a href="/MishaBet?command=showStakes&page=1">${history}</a>
            </li>
            <li>
                <a href="/MishaBet?command=goToDepositWithdrawPage">${depositWithdraw}</a>
            </li>
            <li><p><c:out value="${sessionScope.user.name}"/>
                    ${account}:<c:out value="${sessionScope.user.id}"/>
                    <br/>${balance} : <c:out value="${balance}"/></p></li>
            <li>
            <a href="/MishaBet?command=logout">${logout}</a></li>
        </ul>
    </div>
</nav>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>
</html>
