<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form class="navbar-form navbar-right">
                <sec:authorize access="isAuthenticated()">
                    <a href="/j_spring_security_logout" class="btn btn-danger"><span class="glyphicon glyphicon-log-out"></span> Log out</a>
                </sec:authorize>
            </form>
            <sec:authorize access="isAuthenticated()">
                <sec:authentication var="user" property="principal"/>
                <h4 class="navbar-text navbar-right">${user.username}</h4>
            </sec:authorize>
        </div>

    </div>
</div>
