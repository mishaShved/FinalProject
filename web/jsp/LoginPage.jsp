<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="local.loginPage.accountNumber" var="account"/>
    <fmt:message key="local.loginPage.password" var="password"/>
    <fmt:message key="local.loginPage.loginButton" var="login"/>
    <fmt:message key="local.loginPage.registrationButton" var="registration"/>
    <fmt:message key="local.loginPage.back" var="back"/>
    <fmt:message key="local.loginPage.loginLabel" var="loginLabel"/>
    <fmt:message key="local.loginPage.loginErrorLabel" var="loginErrorLabel"/>
</fmt:bundle>

<html>
<head>
    <title>MBet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPrefix}/css/styles.css">
</head>
<body>

    <div class="content">

    <nav class="navbar navbar-default nav-class">
        <div class="container-fluid">
             <div class="navbar-header icon-class">
                 <a href="${urlPrefix}/MishaBet">
                     MBET
                 </a>
            </div>
            <ul class="nav navbar-nav nav-rigth-class">
                <li><a href="${urlPrefix}/MishaBet">${back}</a></li>
            </ul>
        </div>
    </nav>



    <form action="${urlPrefix}/MishaBet" method="post" class="login-form">



        <div class="login-background">

            <p>${loginLabel}</p>
            <hr/>
        <div class="form-group">
            <label for="input-account-number">${account}</label>
            <input type="number" name="id" class="form-control" id="input-account-number" placeholder="${account}">
        </div>
        <div class="form-group">
            <label for="input-password">${password}</label>
            <input type="password" name="password" class="form-control" id="input-password" placeholder="${password}">
            <p id="login-error">
            <c:if test="${loginFalse == true}">
                ${loginErrorLabel}
            </c:if>
            </p>
        </div>
        <input type="hidden" value="login" name="command">
        <button type="submit" class="btn btn-primary" id="button-submit">${login}</button>
        </div>

    </form>

        <div class="login-background login-form" style=" margin-top: -64px; padding-left: 27.5%;">
        <a href="${urlPrefix}/jsp/RegistrationPage.jsp">
            <button class="btn btn-primary">${registration}</button>
        </a>
        </div>

    </div>

    <jsp:include page="footer/Footer.jsp"/>

    <script type="text/javascript">
        var errorMessages =
            {
                "loginError":"${loginErrorLabel}"
            }
        ;
    </script>

    <script src="${urlPrefix}/script/LoginValidation.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
