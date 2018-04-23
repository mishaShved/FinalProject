<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="pagination" %>
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

    <table class="table table-condensed center-table-class">

        <thead class="table-thead">
        <tr>
            <th>Stake type</th>
            <th>Coefficient</th>
            <th>Result</th>
        </tr>
        </thead>
        <tbody class="table-body-class">

        <c:if test="${stakes.size() > 0}">

        <c:forEach var="i" begin="0" end="${stakes.size() - 1}">
            <tr bgcolor="#d3d3d3">
                <td colspan="3">
                </td>
            </tr>
            <tr>
                <td>
                    <p> <c:out value="${stakes.get(i).betSum}"/>$ </p>
                </td>
                <td>
                    <c:out value="${stakes.get(i).koef}"/>
                </td>
                <td>
                    <c:if test="${stakes.get(i).score1 != -1 && stakes.get(i).isWon() == true}">
                        <p style="color: limegreen"> <c:out value="${stakes.get(i).betSum * stakes.get(i).koef}"/>$</p>
                    </c:if>
                    <c:if test="${stakes.get(i).score1 != -1 && stakes.get(i).isWon() == false}">
                        <p style="color: red"> 0.00$ </p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <p>
                        <c:out value="${stakes.get(i).sportType}"/>.
                        <c:out value="${stakes.get(i).team1}"/> :
                        <c:out value="${stakes.get(i).team2}"/>
                        <c:out value="${stakes.get(i).stakeType}"/>(<c:out value="${stakes.get(i).param}"/>)
                    </p>
                </td>
                <td>
                    <c:if test="${stakes.get(i).score1 != -1}">
                        <c:out value="${stakes.get(i).score1}"/> :  <c:out value="${stakes.get(i).score2}"/>
                    </c:if>
                </td>
            </tr>
        </c:forEach>

        </c:if>

        </tbody>
    </table>

    <div class="pagination-center">
        <p:pagination maxPage="${pageCount}" currentPage="${page}"/>
    </div>

    </div>

    <jsp:include page="footer/Footer.jsp"/>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
