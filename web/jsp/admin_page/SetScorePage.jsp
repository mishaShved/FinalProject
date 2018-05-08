<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

<fmt:bundle basename="locale">
    <fmt:message key="local.setScore.event" var="event"/>
    <fmt:message key="local.setScore.score" var="score"/>
    <fmt:message key="local.setScore.setScoreButton" var="setScoreBtn"/>
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
                <label for="event">${event}</label>
                <select name="eventId" id="event" class="form-control selectpicker" data-live-search="true">
                    <c:forEach var="i" begin="0" end="${eventsList.size() - 1}">
                        <option value="${eventsList.get(i).id}">
                            <span id="team1"><c:out value="${eventsList.get(i).team1}"/> </span> vs <span id="team2"> <c:out value="${eventsList.get(i).team2}"/> </span>
                            <br/>
                            <c:out value="${eventsList.get(i).startTime}"/>
                            <br/>
                            <c:out value="${eventsList.get(i).sportType}"/>
                            <br/>
                        </option>
                    </c:forEach>

                </select>
            </div>

            <div class="form-group">
                <label for="score1" id="score1-label"><p>${score} <c:out value="${eventsList.get(i).team1}"/></p></label>
                <input type="number" name="score1" class="form-control" id="score1" placeholder="Score 1">
            </div>

            <div class="form-group">
                <label for="score2" id="score2-label"><p>${score} <c:out value="${eventsList.get(i).team2}"/></p></label>
                <input type="number" name="score2" class="form-control" id="score2" placeholder="Score 2">
            </div>

            <input type="hidden" name="command" value="setScore">
            <button type="submit" class="btn btn-primary">${setScoreBtn}</button>
        </div>

    </form>

</div>

<jsp:include page="../footer/Footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../../script/ChangeLabelForSetScore.js"></script>

</body>
</html>
