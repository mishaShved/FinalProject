<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

<html>
<head>
    <title>Mbet</title>
</head>
<body>

<div class="content">

    <jsp:include page="header/RegistredUserHeader.jsp">
        <jsp:param value="${balance}" name="balance"/>
    </jsp:include>


    <form action="/MishaBet" method="post" class="login-form">

        <div class="login-background">
            <div class="form-group">
                <label for="deposit">Account</label>
                <input type="number" name="value" class="form-control" id="deposit" placeholder="Account Number">
            </div>
            <input type="hidden" name="command" value="deposit">
            <button type="submit" class="btn btn-primary">Deposit</button>
        </div>

    </form>

    <form action="/MishaBet" method="post" class="login-form">

        <div class="login-background">
            <div class="form-group">
                <label for="withdraw">Account</label>
                <input type="number" name="value" class="form-control" id="withdraw" placeholder="Account Number">
            </div>
            <input type="hidden" name="command" value="withdraw">
            <button type="submit" class="btn btn-primary">Withdraw</button>
        </div>

    </form>



</div>

    <jsp:include page="footer/Footer.jsp"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
