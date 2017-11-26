<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Curator page</title>
    <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>

    <link rel="stylesheet" href="../resources/css/bootstrap-table.css">
    <script src="../resources/js/bootstrap-table.js"></script>
    <script src="../resources/js/custom/curator/curatorPageActions.js"></script>
    <script src="../resources/js/custom/curator/curatorPageListeners.js"></script>
</head>
<body>
    <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

    <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
        <jsp:param name="pageTitle" value="Curator page"/>
        <jsp:param name="titleDescription" value="Actual information for curator."/>
    </jsp:include>

    <h3 class="text-center" style="text-decoration: underline;">Assigned students</h3>
    <div class="container">
        <table class="table table-no-bordered" id="table1" data-toggle="table"
               data-classes="table table-no-bordered"
               data-url=""
               data-id-field="id"
               data-side-pagination="server"
               data-pagination="true"
               data-page-size="5"
               data-page-list="[5, 10, 20]"
               data-search="true">
            <thead>
            <tr>
                <th data-field="name"  >Name</th>
                <th data-field="surname" >Surname</th>
                <th data-field="faculty" >Faculty</th>
                <th data-field="speciality" >Speciality</th>
                <th data-field="budget" >Education basis</th>
                <th data-field="avrMark">Average mark</th>
                <th data-field="status" >Status</th>
                <th data-field="company" >Company</th>
                <th data-field="practicePeriod" >Practice period</th>
                <th data-field="id" data-formatter="LinkFormatter">Show profile</th>
            </tr>
            </thead>
        </table>
    </div>

    <script>
        function LinkFormatter(value, row, index) {
            return "<a href=\"/studentProfile/"+value+"\" class=\"btn btn-default btn-block\">Profile <span class=\"glyphicon glyphicon-user\"></span></a>";
        }
    </script>


    <br/>
    <h3 class="text-center" style="text-decoration: underline;">Practices requests</h3>
    <div class="container">
        <table class="table table-no-bordered" id="curator_practices_table" data-toggle="table"
               data-classes="table table-no-bordered"
               data-url=""
               data-side-pagination="server"
               data-pagination="true"
               data-page-list="[5, 10]"
               data-page-size="5"
               data-search="true"
               data-id-field="id">
            <thead>
            <tr>
                <th data-field="headOfPractice" >Head of practice</th>
                <th data-field="company" >Company name</th>
                <th data-field="firstDate" >Start date</th>
                <th data-field="finishDate" >Finish date</th>
                <th data-field="status" >Status</th>
                <th data-field="faculty">Faculty</th>
                <th data-field="speciality" >Speciality</th>
                <th data-field="avrMark" >Average mark</th>
                <th data-field="totalQuantity" >Total quantity</th>
                <th data-field="availableQuantity">Available quantity</th>
            </tr>
            </thead>
        </table>
    </div>
</body>
</html>
