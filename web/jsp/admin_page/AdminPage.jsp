<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<fmt:bundle basename="locale">
    <fmt:message key="local.adminPage.setScore" var="setScore"/>
    <fmt:message key="local.adminPage.createOdd" var="craeteOdd"/>
    <fmt:message key="local.adminPage.createEvent" var="createEvent"/>
    <fmt:message key="local.adminPage.createEntryLabel" var="entryAddedSuccesfull"/>
</fmt:bundle>


<html>
<head>
    <title>MBet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/styles.css">
</head>
<body>

    <div class="content">

        <jsp:include page="../header/AdminHeader.jsp"/>

        <div class="admin-choice">

            <form action="/MishaBet" method="post">
                <input type="hidden" name="command" value="goToSetScorePage">
                <input type="submit" value="${setScore}">
            </form>

            <form action="/MishaBet" method="post">

                <input type="hidden" name="command" value="goToCreateOddPage">
                <input type="submit" value="${craeteOdd}">

            </form>

            <form action="/MishaBet" method="post">

                <input type="hidden" name="command" value="goToCreateEventPage">
                <input type="submit" value="${createEvent}">

            </form>
        </div>

    </div>


    <jsp:include page="../footer/Footer.jsp"/>

    <script type="text/javascript">
        var successMessage =
            {
                "addedEntry":"${entryAddedSuccesfull}",
            }
        ;
    </script>

    <c:if test="${sessionScope.isUpdated == true}">
        <script src="/script/UpdateAlert.js"></script>
        <c:set value="false" var="isUpdated" scope="session"/>
    </c:if>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
