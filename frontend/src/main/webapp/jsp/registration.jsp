<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
        <script src="../resources/js/custom/registration.js"></script>

    </head>
    <body onload="getFacultiesForRegistrationStudentPage()">
        <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

        <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
            <jsp:param name="pageTitle" value="Registration page"/>
            <jsp:param name="titleDescription" value="Choose necessary tab to continue registration in right way."/>
        </jsp:include>

        <div class="container">
            <ul class="nav nav-tabs" role="tablist">
                <li class="active"><a href="#student" role="tab" data-toggle="tab">Student</a></li>
                <li><a href="#headofpractice" role="tab" data-toggle="tab">Head of practice</a></li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active fade in" role="tab" id="student">
                    <h2 class="text-center">Registration information:</h2>
                    <form class="form-horizontal">

                        <div class="form-group">
                            <label class="control-label col-md-4">Name:</label>
                            <div class="col-md-4">
                                <input id="name_student" type="text" class="form-control" placeholder="Enter name...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Surname:</label>
                            <div class="col-md-4">
                                <input id="surname_student" type="text" class="form-control" placeholder="Enter surname...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Phone number:</label>
                            <div class="col-md-4">
                                <input id="phone_student" type="text" class="form-control" placeholder="*+375441111111...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Email:</label>
                            <div class="col-md-4">
                                <input id="email_student" type="text" class="form-control" placeholder="Enter email...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Choose faculty:</label>
                            <div class="col-md-4">
                                <select id="faculty_name_student" class="form-control" onchange="getSpecialitiesAjaxRequest()">

                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Choose speciality:</label>
                            <div class="col-md-4">
                                <select id="speciality_name_student" class="form-control">

                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Group:</label>
                            <div class="col-md-4">
                                <input id="group_student" type="text" class="form-control" placeholder="*551001...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Average mark:</label>
                            <div class="col-md-4">
                                <input id="average_mark_student" type="text" class="form-control" placeholder="*8...">
                            </div>
                        </div>

                        <div id="radio_Form" class="form-group">
                            <div class="col-md-4 col-md-offset-4">
                            <div class="radio-inline">
                                <label >
                                    <input id="budget_1_student" checked="checked" type="radio" name="isBudget" value="Budget">Budget
                                </label>
                            </div>
                            <div class="radio-inline">
                                <label >
                                    <input id="budget_2_student" type="radio" name="isBudget" value="Chargeable">Chargeable
                                </label>
                            </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Login:</label>
                            <div class="col-md-4">
                                <input id="login_student" type="text" class="form-control" placeholder="Enter login...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Password:</label>
                            <div class="col-md-4">
                                <input id="password_student" type="text" class="form-control" placeholder="Enter password...">
                            </div>
                        </div>
                        <div class="col-md-4 col-md-offset-4">
                            <button type="button" class="btn btn-primary btn-block" onclick="registrationStudentAjaxRequest()">Sign up</button>
                        </div>
                    </form>
                </div>
                <div class="tab-pane fade" role="tab" id="headofpractice">
                    <h2 class="text-center">Registration information:</h2>
                    <form class="form-horizontal">

                        <div class="form-group">
                            <label class="control-label col-md-4">Head of practice name:</label>
                            <div class="col-md-4">
                                <input id="name_headofpractice" type="text" class="form-control" placeholder="Enter name...">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Login:</label>
                            <div class="col-md-4">
                                <input id="login_headofpractice" type="text" class="form-control" placeholder="Enter login...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Password:</label>
                            <div class="col-md-4">
                                <input id="password_headofpractice" type="text" class="form-control" placeholder="Enter password...">
                            </div>
                        </div>

                        <div class="col-md-4 col-md-offset-4">
                            <button type="button" class="btn btn-primary btn-block" onclick="registrationHeadOfPracticeAjaxRequest()">Sign up</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>