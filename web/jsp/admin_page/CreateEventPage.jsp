<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">


<fmt:bundle basename="locale">
    <fmt:message key="local.createEvent.team1EN" var="team1EN"/>
    <fmt:message key="local.createEvent.team2EN" var="team2EN"/>
    <fmt:message key="local.createEvent.team1RU" var="team1RU"/>
    <fmt:message key="local.createEvent.team2RU" var="team2RU"/>
    <fmt:message key="local.createEvent.sport" var="sport"/>
    <fmt:message key="local.createEvent.date" var="date"/>
    <fmt:message key="local.createEvent.time" var="time"/>
    <fmt:message key="local.createEvent.creteEventButton" var="createBtn"/>
    <fmt:message key="local.createEvent.football" var="football"/>
    <fmt:message key="local.createEvent.hockey" var="hockey"/>
    <fmt:message key="local.createEvent.tennis" var="tennis"/>
    <fmt:message key="local.createEvent.volleyball" var="volleyball"/>
    <fmt:message key="local.createEvent.basketball" var="basketball"/>
    <fmt:message key="local.createEvent.handball" var="handball"/>
    <fmt:message key="local.createEvent.cybersport" var="cybersport"/>
</fmt:bundle>


<html>
<head>
    <title>MBet</title>
</head>
<body>

<div class="content">

    <jsp:include page="../header/AdminHeader.jsp"/>

    <form action="/MishaBet" method="post" class="create-event-form">

        <div class="login-background">
            <div class="form-group">
                <label for="team1EN">${team1EN}</label>
                <input type="text" name="team1EN" class="form-control" id="team1EN" placeholder="${team1}">
            </div>
            <div class="form-group">
                <label for="team2EN">${team2EN}</label>
                <input type="text" name="team2EN" class="form-control" id="team2EN" placeholder="${team2}">
            </div>
            <div class="form-group">
                <label for="team1RU">${team1RU}</label>
                <input type="text" name="team1RU" class="form-control" id="team1RU" placeholder="${team1}">
            </div>
            <div class="form-group">
                <label for="team2RU">${team2RU}</label>
                <input type="text" name="team2RU" class="form-control" id="team2RU" placeholder="${team2}">
            </div>
            <div class="form-group">
                <label for="sport">${sport}</label>
                <select name="sport" class="form-control selectpicker" data-live-search="true" id="sport">
                    <option value="HOCKEY">
                        ${hockey}
                    </option>
                    <option value="FOOTBALL">
                        ${football}
                    </option>
                    <option value="BASKETBALL">
                        ${basketball}
                    </option>
                    <option value="VOLLEYBALL">
                        ${volleyball}
                    </option>
                    <option value="TENNIS">
                        ${tennis}
                    </option>
                    <option value="CYBERSPORT">
                        ${cybersport}
                    </option>
                    <option value="HANDBALL">
                        ${handball}
                    </option>
                </select>
            </div>

            <div class="form-group">
                <label for="date">${date}</label>
                <input type="date" name="date" class="form-control" id="date" placeholder="${date}">
            </div>

            <div class="form-group">
                <label for="time">${time}</label>
                <input type="time" name="time" class="form-control" id="time" placeholder="${time}">
            </div>

            <input type="hidden" name="command" value="createEvent">
            <button type="submit" class="btn btn-primary">${createBtn}</button>
        </div>

    </form>

</div>

<jsp:include page="../footer/Footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>