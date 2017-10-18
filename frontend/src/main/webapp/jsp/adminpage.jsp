<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Administration</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
    </head>
    <body>

        <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

        <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
            <jsp:param name="pageTitle" value="Administration page"/>
            <jsp:param name="titleDescription" value="Actual information about all students."/>
        </jsp:include>

        <div class="container">
            <div class="btn-toolbar">
                <div class="btn-group ">
                    <a href="createFaculty.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Create faculty / speciality</a>
                    <a href="registration.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Register student / head of practice</a>
                </div>

                <div class="btn-group ">
                    <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Assign student(s)</button>
                    <button type="submit" class="btn btn-primary">Release student(s)</button>
                </div>

                <div class="btn-group ">
                    <a href="allRequests.jsp" class="btn btn-primary">Show all requests</a>
                </div>

                <div class="btn-group ">
                    <button type="submit" class="btn btn-danger">Delete student(s) <span class="glyphicon glyphicon-trash"></span></button>
                </div>

            </div>
        </div>

        <br/>
        <div class="container table-responsive">
            <table class="table table-condensed table-striped">
                <thead>
                <tr>
                    <th>Choice</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Faculty</th>
                    <th>Speciality</th>
                    <th>Education basis</th>
                    <th>Average mark</th>
                    <th>Status</th>
                    <th>Company</th>
                    <th>Practice period</th>
                    <th>Show profile</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><div class="checkbox"><label><input type="checkbox"></label></div></td>
                    <td>Dmitry</td>
                    <td>Chekh</td>
                    <td>FSCAN</td>
                    <td>ITS</td>
                    <td>Chargeable</td>
                    <td>8.3</td>
                    <td>Busy</td>
                    <td>Netcracker</td>
                    <td>10.09.2017 - 10.12.2017</td>
                    <td><a href="studentprofile.jsp" class="btn btn-default btn-block">Profile <span class="glyphicon glyphicon-user"></span></a></td>
                </tr>
                <tr>
                    <td><div class="checkbox"><label><input type="checkbox"></label></div></td>
                    <td>Vlad</td>
                    <td>Gorbunov</td>
                    <td>FCP</td>
                    <td>MH</td>
                    <td>Budget</td>
                    <td>8.0</td>
                    <td>Available</td>
                    <td>-</td>
                    <td>-</td>
                    <td><a href="studentprofile.jsp" class="btn btn-default btn-block">Profile <span class="glyphicon glyphicon-user"></span></a></td>
                </tr>
                <tr>
                    <td><div class="checkbox"><label><input type="checkbox"></label></div></td>
                    <td>Stas</td>
                    <td>Kroshinskiy</td>
                    <td>FSCAN</td>
                    <td>ITS</td>
                    <td>Budget</td>
                    <td>9.0</td>
                    <td>Busy</td>
                    <td>EPAM</td>
                    <td>21.08.2017 - 21.12.2017</td>
                    <td><a href="studentprofile.jsp" class="btn btn-default btn-block">Profile <span class="glyphicon glyphicon-user"></span></a></td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">x</button>
                        <h4 class="modal-title">Assign student(s)</h4>
                    </div>
                    <div class="modal-body">
                        <h2 class="text-center">Assign information:</h2>

                        <div class="table-responsive">
                            <table class="table table-condensed table-striped">
                                <thead>
                                <th>Student name</th>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Chekh Dmitry</td>
                                </tr>
                                <tr>
                                    <td>Vlad Gorbunov</td>
                                </tr>
                                <tr>
                                    <td>Vadim Bokov</td>
                                </tr>
                                <tr>
                                    <td>Roma Martsenuk</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <form>
                            <div class="form-group">
                                <label class="control-label ">Choose practice request:</label>
                                <div class="">
                                    <select class="form-control">
                                        <option>Netcracker</option>
                                        <option>EPAM</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success btn-block">Assign student(s)</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>
