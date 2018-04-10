<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <label for="team1">Team1</label>
                <input type="text" name="team1" class="form-control" id="team1" placeholder="Team1">
            </div>
            <div class="form-group">
                <label for="team2">Team1</label>
                <input type="text" name="team2" class="form-control" id="team2" placeholder="Team2">
            </div>
            <div class="form-group">
                <label for="sport">Sport</label>
                <select name="sport" class="form-control selectpicker" data-live-search="true" id="sport">
                    <option value="HOCKEY">
                        HOCKEY
                    </option>
                    <option value="FOOTBALL">
                        FOOTBALL
                    </option>
                    <option value="BASKETBALL">
                        BASKETBALL
                    </option>
                    <option value="VOLLEYBALL">
                        VOLLEYBALL
                    </option>
                    <option value="TENNIS">
                        TENNIS
                    </option>
                    <option value="CYBERSPORT">
                        CYBERSPORT
                    </option>
                    <option value="HANDBALL">
                        HANDBALL
                    </option>
                </select>
            </div>

            <div class="form-group">
                <label for="date">Date</label>
                <input type="date" name="date" class="form-control" id="date" placeholder="Date">
            </div>

            <div class="form-group">
                <label for="time">Time</label>
                <input type="time" name="time" class="form-control" id="time" placeholder="Time">
            </div>

            <input type="hidden" name="command" value="createEvent">
            <button type="submit" class="btn btn-primary">Create event</button>
        </div>

    </form>

</div>

<jsp:include page="../footer/Footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>