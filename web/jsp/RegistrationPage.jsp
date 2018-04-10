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

        <nav class="navbar navbar-default nav-class">
            <div class="container-fluid">
                <div class="navbar-header icon-class">
                    MBET
                </div>
                <ul class="nav navbar-nav nav-rigth-class">
                    <li><a href="StartPage.jsp">Back</a></li>
                </ul>
            </div>
        </nav>

        <form action="/MishaBet" method="post" class="registration-form">

            <div class="login-background">
                <div class="form-group">
                    <label for="input-name">Name</label>
                    <input type="text" name="name" class="form-control" id="input-name" placeholder="Name">
                </div>
                <div class="form-group">
                    <label for="input-email">E-Mail</label>
                    <input type="password" name="email" class="form-control" id="input-email" placeholder="E-Mail">
                </div>
                <div class="form-group">
                    <label for="input-password">Password</label>
                    <input type="password" name="password" class="form-control" id="input-password" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="repeat-password">Repeat password</label>
                    <input type="password" name="repeatPassword" class="form-control" id="repeat-password" placeholder="Password">
                </div>
                <input type="hidden" value="registration" name="command">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>

        </div>

        <jsp:include page="footer/Footer.jsp"/>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </body>
</html>
