<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<c:set var="urlPrefix" value="${pageContext.request.contextPath}"/>

<fmt:bundle basename="locale">
    <fmt:message key="local.header.balance" var="balanceWord"/>
    <fmt:message key="local.header.accountNumber" var="account"/>
    <fmt:message key="local.header.logout" var="logout"/>
    <fmt:message key="local.header.settings" var="settings"/>
    <fmt:message key="local.header.accountHistory" var="history"/>
    <fmt:message key="local.header.depositWithdraw" var="depositWithdraw"/>
</fmt:bundle>


<nav class="navbar navbar-default nav-class">
    <div class="container-fluid">
        <div class="navbar-header icon-class">
            <a href="${urlPrefix}/MishaBet">
                MBET
            </a>
        </div>
        <ul class="nav navbar-nav nav-rigth-class">
            <li>
                <a href="${urlPrefix}/MishaBet?command=showStakes&page=1">${history}</a>
            </li>
            <li>
                <a href="${urlPrefix}/MishaBet?command=goToDepositWithdrawPage">${depositWithdraw}</a>
            </li>
            <li><p><c:out value="${sessionScope.user.name}"/>
                    ${account}:<c:out value="${sessionScope.user.id}"/>
                    <br/>${balanceWord} : <c:out value="${balance}"/></p></li>
            <li>
            <a href="${urlPrefix}/MishaBet?command=logout">${logout}</a></li>
        </ul>
    </div>
</nav>

