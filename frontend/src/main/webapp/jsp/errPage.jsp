<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
    <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
</head>
<body>

    <%--<jsp:include page="/jsp/blocks/sitenavbar.jsp"/>--%>

    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/home"><span class="	glyphicon glyphicon-blackboard"></span> PracticeManager</a>
            </div>

            <div class="navbar-collapse collapse">
                <%--<form class="navbar-form navbar-right">--%>
                    <%--<a href="/j_spring_security_logout" class="btn btn-danger"><span class="glyphicon glyphicon-log-out"></span> Log out</a>--%>
                <%--</form>--%>
                <%--<h4 class="navbar-text navbar-right"><%= SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")? "" : SecurityContextHolder.getContext().getAuthentication().getName()%></h4>--%>
            </div>
        </div>
    </div>

    <div class="jumbotron">
        <div class="container">
            <h1>Error page</h1>
            <p>${errorMsg}</p>
        </div>
    </div>

    <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
</body>
</html>