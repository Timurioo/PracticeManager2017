<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Authorization</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
    </head>
    <body>
        <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

        <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
            <jsp:param name="pageTitle" value="Authorization page"/>
            <jsp:param name="titleDescription" value="Choose necessary role to continue authorization in right way."/>
        </jsp:include>

        <div class="container">
            <h2 class="text-center">Authorization information:</h2>
            <form class="form-horizontal" name="form_login" action="/j_spring_security_check" method="post">

                <div class="form-group">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="radio-inline">
                            <label >
                                <input checked="checked" type="radio" name="role">Student
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label >
                                <input type="radio" name="role">Head of practice
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label >
                                <input type="radio" name="role">Administrator
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Login:</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" name="user_login" placeholder="Enter login...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Password:</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" name="user_password" placeholder="Enter password...">
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox col-md-4 col-md-offset-4"><label class="control-label"><input name="_spring_security_remember_me" type="checkbox">Remember me</label></div>
                </div>
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" name="submit" class="btn btn-success btn-block" value="submit">Sign in <span class="	glyphicon glyphicon-ok"></span></button>
                </div>
            </form>
        </div>

        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>