<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

<fmt:bundle basename="locale">
    <fmt:message key="local.startPage.registrationInfo" var="message"/>
</fmt:bundle>


<html>

<head>

    <title>MBet</title>

</head>


<body>


    <div class="content">


        <c:if test="${sessionScope.user == null}">
            <jsp:include page="header/GuestHeader.jsp"/>
        </c:if>

        <c:if test="${sessionScope.user != null}">
            <jsp:include page="header/RegistredUserHeader.jsp">
                    <jsp:param name="balance" value="${balance}"/>
            </jsp:include>
        </c:if>

        <jsp:include page="EventsTable.jsp"/>

    </div>

    <jsp:include page="footer/Footer.jsp"/>




    <script type="text/javascript">
        var registrationInfo =
            {
                "message":"${message}",
                "accountNumber":"${sessionScope.user_id}"
            }
        ;
    </script>

    <c:if test="${sessionScope.user_id != null && sessionScope.user_id != 0}">
        <script src="/script/UserRegistrationInfo.js"></script>
        <c:set scope="session" var="user_id" value="0"/>
    </c:if>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>


</html>
