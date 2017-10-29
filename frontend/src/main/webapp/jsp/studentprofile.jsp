<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student profile</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>

        <!-- AJAX -->
        <script type="text/javascript">

            function $_GET(key) {
                var s = window.location.search;
                s = s.match(new RegExp(key + '=([^&=]+)'));
                return s ? s[1] : null;
            }

            function doAjax() {
                $.ajax({
                    url: 'studentProfileData?id='+$_GET("id"),
                    data: (''),
                    success: function (data) {
                        $('#name').html("Name: "+data.name);
                        $('#surname').html("Surname: "+data.surname);
                        $('#phone').html("Phone: "+data.phone);
                        $('#email').html("Name: "+data.email);
                        $('#faculty').html("Faculty: "+data.faculty);
                        $('#speciality').html("Speciality: "+data.speciality);
                        $('#group').html("Group: "+data.group);
                        $('#budget').html("Education basis: "+data.budget);
                        $('#avrMark').html("Average mark: "+data.avrMark);
                        $('#status').html("Status: "+data.status);
                        if (data.company != null && data.practicePeriod != null){
                            $('#company').html("Company name: "+data.company);
                            $('#practicePeriod').html("Period of practice: "+data.practicePeriod);
                        }else{
                            $('#company').html("Company name: - ");
                            $('#practicePeriod').html("Period of practice: - ");
                        }

                    }
                });
            }



        </script>
    </head>
    <body onload="doAjax()">
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
                            <p id="name"></p>
                            <p id="surname"></p>
                            <p id="phone"></p>
                            <p id="email"></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            <h3>Education information <span class="glyphicon glyphicon-education "></span></h3>
                        </div>
                        <div class="panel-body">
                            <p id="faculty"></p>
                            <p id="speciality"></p>
                            <p id="group"></p>
                            <p id="budget"></p>
                            <p id="avrMark"></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="panel panel-default ">
                        <div class="panel-heading">
                            <h3>Practice information  <span class="glyphicon glyphicon-stats "></span></h3>

                        </div>
                        <div class="panel-body">
                            <p id="status"></p>
                            <p id="company"></p>
                            <p id="practicePeriod"></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>