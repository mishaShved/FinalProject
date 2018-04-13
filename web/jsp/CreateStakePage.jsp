<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/styles.css">

<html>

    <head>
        <title>MBET</title>
    </head>


    <body>

        <div class="content">

            <jsp:include page="header/RegistredUserHeader.jsp">
                <jsp:param value="${balance}" name="balance"/>
            </jsp:include>





        </div>

        <jsp:include page="footer/Footer.jsp"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </body>


</html>
