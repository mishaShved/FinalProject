<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="local.registration.name" var="name"/>
    <fmt:message key="local.registration.password" var="password"/>
    <fmt:message key="local.registration.repeatPass" var="repeatPass"/>
    <fmt:message key="local.registration.email" var="email"/>
    <fmt:message key="local.registration.regBtn" var="regBtn"/>
    <fmt:message key="local.registration.back" var="back"/>
    <fmt:message key="local.registration.nameVerificationError" var="nameVerificationError"/>
    <fmt:message key="local.registration.passwordVerificationError" var="passwordVerificationError"/>
    <fmt:message key="local.registration.emailVerificationError" var="emailVerificationError"/>
    <fmt:message key="local.registration.repeatPasswordVerificationError" var="repeatPasswordVerificationError"/>
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
                    <a href="${urlPrefix}/MishaBet">MBET</a></li>
                </div>
                <ul class="nav navbar-nav nav-rigth-class">
                    <li><a href="${urlPrefix}/MishaBet">${back}</a></li>
                </ul>
            </div>
        </nav>

        <form action="${urlPrefix}/MishaBet" method="post" class="registration-form">

            <div class="login-background">
                <div class="form-group">
                    <label for="input-name">${name}</label>
                    <input type="text" name="name" class="form-control" id="input-name" placeholder="${name}">
                    <p id="name-failed"></p>
                </div>
                <div class="form-group">
                    <label for="input-email">${email}</label>
                    <input type="email" name="email" class="form-control" id="input-email" placeholder="${email}">
                    <p id="email-failed"></p>
                </div>
                <div class="form-group">
                    <label for="input-password">${password}</label>
                    <input type="password" name="password" class="form-control" id="input-password" placeholder="${password}">
                    <p id="password-failed"></p>
                </div>
                <div class="form-group">
                    <label for="repeat-password">${repeatPass}</label>
                    <input type="password" name="repeatPassword" class="form-control" id="repeat-password" placeholder="${repeatPass}">
                    <p id="repeat-password-failed"></p>
                </div>
                <input type="hidden" value="registration" name="command">
                <button type="submit" class="btn btn-primary" id="button-submit">${regBtn}</button>
            </div>

        </form>

        </div>

        <jsp:include page="footer/Footer.jsp"/>

        <script type="text/javascript">
            var validationMessages =
                {
                    "repeatPasswordVerificationError":"${repeatPasswordVerificationError}",
                    "passwordVerificationError":"${passwordVerificationError}",
                    "nameVerificationError":"${nameVerificationError}",
                    "emailVerificationError":"${emailVerificationError}"
                }
            ;
        </script>


        <script type="text/javascript" src="${urlPrefix}/script/RegistrationValidation.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </body>
</html>
