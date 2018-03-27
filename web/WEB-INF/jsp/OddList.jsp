<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:out value="${odds.get(0).team1}"/> vs <c:out value="${odds.get(0).team2}"/>

    <table>
        <c:forEach var="i" begin="0" end="${odds.size() - 1}">
        <tr>

            <td>
                <c:out value="${odds.get(i).oddType.name()}"/>
            </td>

            <td>
                <c:out value="${odds.get(i).koef}"/>
            </td>

            <td>
                <c:out value="${odds.get(i).param}"/>
            </td>

            <td>
                <form action="/MishaBet" method="post">

                    <input type="hidden" name="command" value="createStacke">
                    <input type="submit" value="Place bet">
                    <input type="hidden" name="koef" value="${odds.get(i).koef}">
                    <input type="number" name="money" value="">
                    <input type="hidden" name="oddId" value="${odds.get(i).id}">

                </form>
            </td>

        </tr>
        </c:forEach>

    </table>
</body>
</html>
