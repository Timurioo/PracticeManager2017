<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
    <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
</head>
<body>

    <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

    <div class="jumbotron">
        <div class="container">
            <h1>Error page</h1>
            <p>${errorMsg}</p>
        </div>
    </div>

    <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
</body>
</html>