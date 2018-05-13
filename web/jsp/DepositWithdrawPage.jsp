<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="local.depositWithdraw.depositButton" var="deposit"/>
    <fmt:message key="local.depositWithdraw.withdrawButton" var="withdraw"/>
    <fmt:message key="local.depositWithdraw.money" var="money"/>
</fmt:bundle>

<html>
<head>
    <title>Mbet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPrefix}/css/styles.css">
</head>
<body>

<div class="content">

    <jsp:include page="header/RegistredUserHeader.jsp">
        <jsp:param value="${balance}" name="balance"/>
    </jsp:include>

    <div class="login-form">

    <form action="${urlPrefix}/MishaBet" method="post">

        <div class="login-background">
            <div class="form-group">
                <label for="deposit">${deposit}</label>
                <input pattern="\d+(\.\d{0,2})?" name="value" class="form-control" id="deposit" placeholder="${money}">
            </div>
            <input type="hidden" name="command" value="deposit">
            <button type="submit" class="btn btn-primary">${deposit}</button>
        </div>

    </form>

    <form action="${urlPrefix}/MishaBet" method="post">

        <div class="login-background">
            <div class="form-group">
                <label for="withdraw">${withdraw}</label>
                <input pattern="\d+(\.\d{0,2})?" name="value" class="form-control" id="withdraw" placeholder="${money}">
            </div>
            <input type="hidden" name="command" value="withdraw">
            <button type="submit" class="btn btn-primary">${withdraw}</button>
        </div>

    </form>

    </div>



</div>

    <jsp:include page="footer/Footer.jsp"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
