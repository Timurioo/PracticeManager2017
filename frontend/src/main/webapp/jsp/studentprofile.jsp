<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student profile</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
    </head>
    <body>
        <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

        <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
            <jsp:param name="pageTitle" value="Student profile"/>
            <jsp:param name="titleDescription" value="Full actual information about certain student."/>
        </jsp:include>

        <div class="container-fluid text-center">
            <div class="row">
                <div class="col-md-4">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            <h3>Contact information <span class="glyphicon glyphicon-user"></span> </h3>
                        </div>
                        <div class="panel-body">
                            <p>Name: Dmitry</p>
                            <p>Surname: Chekh</p>
                            <p>Phone: +375447644696</p>
                            <p>Email: dimacheh97@mail.ru</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            <h3>Education information <span class="glyphicon glyphicon-education "></span></h3>
                        </div>
                        <div class="panel-body">
                            <p>Faculty: FSCAN</p>
                            <p>Speciality: ITS</p>
                            <p>Year fo study: 3</p>
                            <p>Group: 551001</p>
                            <p>Education basis: Chargeable</p>
                            <p>Average mark: 8.3</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            <h3>Practice information  <span class="glyphicon glyphicon-stats "></span></h3>

                        </div>
                        <div class="panel-body">
                            <p>Status: Busy</p>
                            <p>Company name: Netcracker</p>
                            <p>Period of practice: 10.09.2017 - 10.12.2017</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>