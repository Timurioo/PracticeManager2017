<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
        <link rel="stylesheet" href="../resources/css/custom/registration.css">
        <script src="../resources/js/jquery.validate.min.js"></script>
        <script src="../resources/js/additional-methods.js"></script>
        <script src="../resources/js/jquery.md5.js"></script>
        <script src="../resources/js/custom/registration/student/registrationStudentActions.js"></script>
        <script src="../resources/js/custom/registration/student/registrationStudentValidation.js"></script>
    </head>
    <body>
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
                    <form id="student_form" class="form-horizontal">

                        <div class="form-group">
                            <label class="control-label col-md-4">Name:</label>
                            <div class="col-md-4">
                                <input id="name_student" name="name_s" type="text" class="form-control" placeholder="Enter name...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Surname:</label>
                            <div class="col-md-4">
                                <input id="surname_student" name="surname_s" type="text" class="form-control" placeholder="Enter surname...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Phone number:</label>
                            <div class="col-md-4">
                                <input id="phone_student" name="phone_s" type="tel" class="form-control" placeholder="80291112233">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Email:</label>
                            <div class="col-md-4">
                                <input id="email_student" name="email_s"  type="email" class="form-control" placeholder="Enter email...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Choose faculty:</label>
                            <div class="col-md-4">
                                <select id="faculty_name_student" name="faculty_s" class="form-control">

                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Choose speciality:</label>
                            <div class="col-md-4">
                                <select id="speciality_name_student" name="speciality_s" class="form-control">

                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Group:</label>
                            <div class="col-md-4">
                                <input id="group_student" name="group_s" type="text" class="form-control" placeholder="*551001...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Average mark:</label>
                            <div class="col-md-4">
                                <input id="average_mark_student" name="avr_mark_s" type="text" class="form-control" placeholder="*8...">
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
                                <input id="login_student" name="login_s" type="text" class="form-control" placeholder="Enter login...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Password:</label>
                            <div class="col-md-4">
                                <input id="password_student" name="pass_s" type="text" class="form-control" placeholder="Enter password...">
                            </div>
                        </div>
                        <div class="col-md-4 col-md-offset-4">
                            <button id="submit_student_btn" disabled="disabled" type="button" class="btn btn-primary btn-block">Sign up</button>
                        </div>
                    </form>
                </div>
                <div class="tab-pane fade" role="tab" id="headofpractice">
                    <h2 class="text-center">Registration information:</h2>
                    <form id="head_of_practice_form" class="form-horizontal">

                        <div class="form-group">
                            <label class="control-label col-md-4">Head of practice name:</label>
                            <div class="col-md-4">
                                <input id="name_headofpractice" name="name_h" type="text" class="form-control" placeholder="Enter name...">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Login:</label>
                            <div class="col-md-4">
                                <input id="login_headofpractice" name="login_h" type="text" class="form-control" placeholder="Enter login...">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Password:</label>
                            <div class="col-md-4">
                                <input id="password_headofpractice" name="pass_h" type="text" class="form-control" placeholder="Enter password...">
                            </div>
                        </div>

                        <div class="col-md-4 col-md-offset-4">
                            <button id="submit_headofpractice_btn" disabled="disabled" type="button" class="btn btn-primary btn-block">Sign up</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!--Alert Modal -->
        <div class="modal fade" id="alert_modal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">x</button>
                    </div>
                    <div class="modal-body">
                        <div class="alert alert-success">
                            <strong>Success!</strong> <span id="alert_text"></span> has been saved!
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success btn-block" data-dismiss="modal" id="alert_close_btn">Ok</button>
                    </div>
                </div>
            </div>
        </div>



        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>