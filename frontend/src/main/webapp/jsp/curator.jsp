<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Curator page</title>
    <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>

    <link rel="stylesheet" href="../resources/css/bootstrap-table.css">
    <script src="../resources/js/bootstrap-table.js"></script>
    <script src="../resources/js/custom/curator/curatorPageActions.js"></script>
</head>
<body>
    <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

    <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
        <jsp:param name="pageTitle" value="Curator page"/>
        <jsp:param name="titleDescription" value="Actual information for curator."/>
    </jsp:include>

    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="text-center" style="text-decoration: underline; color: rgba(180, 176, 176, 0.80); font-weight: bold;" >Assign students information table</h3>
            </div>
            <div class="panel-body">
                <table class="table table-no-bordered" id="table1" data-toggle="table"
                       data-classes="table table-no-bordered"
                       data-url=""
                       data-id-field="id"
                       data-side-pagination="server"
                       data-pagination="true"
                       data-page-size="5"
                       data-page-list="[5, 10, 20]"
                       data-search="true"
                       data-filter-show-clear="true"
                       data-show-refresh="true"
                       data-show-toggle="true">
                    <thead>
                    <tr>
                        <th data-field="name" data-align="center">Name</th>
                        <th data-field="surname" data-align="center">Surname</th>
                        <th data-field="faculty" data-align="center">Faculty</th>
                        <th data-field="speciality" data-align="center">Speciality</th>
                        <th data-field="budget" data-align="center">Education basis</th>
                        <th data-field="avrMark" data-align="center">Average mark</th>
                        <th data-field="status" data-align="center">Status</th>
                        <th data-field="company" data-align="center">Company</th>
                        <th data-field="practicePeriod" data-align="center">Practice period</th>
                        <th data-field="id" data-formatter="LinkFormatter">Show profile</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>

    <script>
        function LinkFormatter(value, row, index) {
            return "<a href=\"/studentProfile/"+value+"\" class=\"btn btn-default btn-block\">Profile <span class=\"glyphicon glyphicon-user\"></span></a>";
        }
    </script>


    <br/>
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="text-center" style="text-decoration: underline; color: rgba(180, 176, 176, 0.80); font-weight: bold;" >Practice information table</h3>
            </div>
            <div class="panel-body">
                <table class="table table-no-bordered" id="curator_practices_table" data-toggle="table"
                       data-classes="table table-no-bordered"
                       data-url=""
                       data-side-pagination="server"
                       data-pagination="true"
                       data-page-list="[5, 10]"
                       data-page-size="5"
                       data-search="true"
                       data-id-field="id"
                       data-filter-show-clear="true"
                       data-show-refresh="true"
                       data-show-toggle="true">
                    <thead>
                    <tr>
                        <th data-field="headOfPractice" data-align="center">Head of practice</th>
                        <th data-field="company" data-align="center">Company name</th>
                        <th data-field="firstDate" data-align="center">Start date</th>
                        <th data-field="finishDate" data-align="center">Finish date</th>
                        <th data-field="status" data-align="center">Status</th>
                        <th data-field="faculty" data-align="center">Faculty</th>
                        <th data-field="speciality" data-align="center">Speciality</th>
                        <th data-field="avrMark" data-align="center">Average mark</th>
                        <th data-field="totalQuantity" data-align="center">Total quantity</th>
                        <th data-field="availableQuantity" data-align="center">Available quantity</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
    <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
</body>
</html>
