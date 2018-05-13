<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<fmt:bundle basename="locale">
    <fmt:message key="local.startPage.football" var="football"/>
    <fmt:message key="local.startPage.hockey" var="hockey"/>
    <fmt:message key="local.startPage.tennis" var="tennis"/>
    <fmt:message key="local.startPage.volleyball" var="volleyball"/>
    <fmt:message key="local.startPage.handball" var="handball"/>
    <fmt:message key="local.startPage.basketball" var="basketball"/>
    <fmt:message key="local.startPage.cybersport" var="cybersport"/>
</fmt:bundle>

<div onload="update('CYBERSPORT');">

<ul class="nav nav-tabs nav-tabs-center" id="sport-type" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" id="football" data-toggle="tab" href="#football" role="tab" aria-controls="football" aria-selected="true">${football}</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="hockey" data-toggle="tab" href="#hockey" role="tab" aria-controls="hockey" aria-selected="false">${hockey}</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="tennis" data-toggle="tab" href="#tennis" role="tab" aria-controls="tennis" aria-selected="false">${tennis}</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="volleyball" data-toggle="tab" href="#volleyball" role="tab" aria-controls="volleyball" aria-selected="false">${volleyball}</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="basketball" data-toggle="tab" href="#basketball" role="tab" aria-controls="basketball" aria-selected="false">${basketball}</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="handball" data-toggle="tab" href="#handball" role="tab" aria-controls="handball" aria-selected="false">${handball}</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="cybersport" data-toggle="tab" href="#cybersport" role="tab" aria-controls="cybersport" aria-selected="false">${cybersport}</a>
    </li>
</ul>

</div>

<table class="table table-condensed center-table-class" id="events-table" >

</table>

<script type="text/javascript" src="${urlPrefix}/script/ChangeSportType.js"></script>
<script type="text/javascript" src="${urlPrefix}/script/UpdateTable.js"></script>


