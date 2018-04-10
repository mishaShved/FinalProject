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

        <c:if test="${sessionScope.user == null}">
            <jsp:include page="header/GuestHeader.jsp"/>
        </c:if>

        <c:if test="${sessionScope.user != null}">
            <jsp:include page="header/RegistredUserHeader.jsp">
                <jsp:param name="balance" value="${balance}"/>
            </jsp:include>
        </c:if>




        <table class="table table-condensed table-odds" id="table">
                <caption align="left" class="teams-on-odds-list"> <c:out value="${odds.getOdd(0).team1}"/><br/><c:out value="${odds.getOdd(0).team2}"/></caption>
                <tr>
                    <td>W1</td>
                    <td>X</td>
                    <td>W2</td>
                </tr>
                <tr>
                    <td><c:out value="${odds.getOdd('W1').koef}"/></td>
                    <td><c:out value="${odds.getOdd('X').koef}"/></td>
                    <td><c:out value="${odds.getOdd('W2').koef}"/></td>
                </tr>

                <tr>
                    <td colspan="3" bgcolor="#d3d3d3"></td>
                </tr>

                <tr>
                    <td>1X</td>
                    <td>12</td>
                    <td>2X</td>
                </tr>
                <tr>
                    <td><c:out value="${odds.getOdd('X1').koef}"/></td>
                    <td><c:out value="${odds.getOdd('NOTX').koef}"/></td>
                    <td><c:out value="${odds.getOdd('X2').koef}"/></td>
                </tr>

                <tr>
                    <td colspan="3" bgcolor="#d3d3d3"></td>
                </tr>

                <tr>
                    <td><p>TM  <c:out value="${odds.getOdd('TM').oddType.name()}"/> </p></td>
                    <td></td>
                    <td><p>TL  <c:out value="${odds.getOdd('TL').oddType.name()}"/> </p></td>
                </tr>
                <tr>
                    <td><c:out value="${odds.getOdd('TM').koef}"/></td>
                    <td></td>
                    <td><c:out value="${odds.getOdd('TL').koef}"/></td>
                </tr>

                <tr>
                    <td colspan="3" bgcolor="#d3d3d3"></td>
                </tr>

                <tr>
                    <td><p>F1  <c:out value="${odds.getOdd('F1').oddType.name()}"/> </p></td>
                    <td></td>
                    <td><p>F2  <c:out value="${odds.getOdd('F2').oddType.name()}"/> </p></td>
                </tr>
                <tr>
                    <td><c:out value="${odds.getOdd('F1').koef}"/></td>
                    <td></td>
                    <td><c:out value="${odds.getOdd('F2').koef}"/></td>
                </tr>

        </table>

    </div>

    <jsp:include page="footer/Footer.jsp"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
