<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">
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

                <label for="oddType">Event</label>
                <select name="oddType"  id="oddType" class="form-control selectpicker" data-live-search="true">

                    <c:forEach var="i" begin="0" end="${oddTypesCount}">
                        <option value="${oddTypes[i]}">
                            <c:out value="${oddTypes[i]}"/>
                        </option>
                    </c:forEach>
                </select>

            </div>
            <div class="form-group">
                <label for="event">Event</label>
                <select name="eventId" id="event" class="form-control selectpicker" data-live-search="true">

                    <c:forEach var="i" begin="0" end="${eventsList.size() - 1}">
                        <option value="${eventsList.get(i).id}">
                            <c:out value="${eventsList.get(i).team1}"/> vs <c:out value="${eventsList.get(i).team2}"/>
                            <br/>
                            <c:out value="${eventsList.get(i).startTime}"/>
                            <br/>
                            <c:out value="${eventsList.get(i).sportType.name()}"/>
                            <br/>
                        </option>
                    </c:forEach>

                </select>
            </div>

            <div class="form-group">
                <label for="koef">Coefficient</label>
                <input type="text" name="koef" class="form-control" id="koef" placeholder="Coefficient">
            </div>

            <div class="form-group">
                <label for="param">Param</label>
                <input type="text" name="param" class="form-control" id="param" placeholder="Parameter">
            </div>

            <input type="hidden" name="command" value="createOdd">
            <button type="submit" class="btn btn-primary">Create odd</button>
        </div>

    </form>

</div>

<jsp:include page="../footer/Footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
