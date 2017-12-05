<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create request</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
        <link rel="stylesheet" href="../resources/css/custom/registration.css">
        <script src="../resources/js/jquery.validate.min.js"></script>
        <script src="../resources/js/additional-methods.js"></script>
        <script src="../resources/js/custom/registration/practice/registrationPracticeRequestActions.js"></script>
        <script src="../resources/js/custom/registration/practice/registrationPracticeRequestValidation.js"></script>
    </head>
    <body>
        <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

        <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
            <jsp:param name="pageTitle" value="Creation request page"/>
            <jsp:param name="titleDescription" value="Fill all text-fields to continue creation in right way."/>
        </jsp:include>

        <div class="container">
            <h2 class="text-center">Creation information:</h2>
            <form id="id_practice_form" class="form-horizontal">

                <div class="form-group">
                    <label class="control-label col-md-4">Choose head of practice:</label>
                    <div class="col-md-4">
                        <select id="head_of_practices" class="form-control">

                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Company name:</label>
                    <div class="col-md-4">
                        <input id="name_company" name="company_name" type="text" class="form-control" placeholder="Enter name...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Start date:</label>
                    <div class="col-md-4">
                        <input id="first_date" name="first_d" type="date" class="form-control" placeholder="Choose date...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Finish date:</label>
                    <div class="col-md-4">
                        <input id="finish_date" name="finish_d" type="date" class="form-control" placeholder="Choose date...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Choose faculty:</label>
                    <div class="col-md-4">
                        <select id="faculties" class="form-control">

                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Choose speciality:</label>
                    <div class="col-md-4">
                        <select id="specialities" class="form-control">

                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Average mark:</label>
                    <div class="col-md-4">
                        <input id="avr_mark" name="average_mark" type="text" class="form-control" placeholder="Enter minimum mark...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Total quantity:</label>
                    <div class="col-md-4">
                        <input id="total_quantity" name="total_q" type="text" class="form-control" placeholder="*20...">
                    </div>
                </div>

                <div class="col-md-4 col-md-offset-4">
                    <button id="submit_practice_btn" disabled="disabled" type="button" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-plus"></span> Create practice request</button>
                </div>
            </form>
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