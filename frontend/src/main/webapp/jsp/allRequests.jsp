<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Request list</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>

        <link rel="stylesheet" href="../resources/css/bootstrap-table.css">
        <script src="../resources/js/bootstrap-table.js"></script>
        <script src="../resources/js/lodash.min.js"></script>
        <script src="../resources/js/custom/practicespage/practicesPageActions.js"></script>

    </head>
    <body>
        <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

        <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
            <jsp:param name="pageTitle" value="Requests page"/>
            <jsp:param name="titleDescription" value="Actual information about all practice requests."/>
        </jsp:include>


        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="text-center" style="text-decoration: underline; color: rgba(180, 176, 176, 0.80); font-weight: bold;" >Practice information table</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-2">
                            <a href="/registration/practice" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-plus"></span> Create request</a>
                        </div>
                        <div class="col-md-2">
                            <button id="delete_practices_btn" disabled="disabled" type="submit" class="btn btn-danger btn-block"> Delete request  <span class="glyphicon glyphicon-trash"></span></button>
                        </div>
                    </div>

                    <table class="table table-no-bordered" id="table1" data-toggle="table"
                   data-classes="table table-no-bordered"
                   data-click-to-select="true"
                   data-url="/practices"
                   data-side-pagination="server"
                   data-pagination="true"
                   data-page-list="[5, 10]"
                   data-page-size="5"
                   data-search="true"
                   data-response-handler="responseHandler"
                   data-id-field="id"
                   data-filter-show-clear="true"
                   data-show-refresh="true"
                   data-show-toggle="true">
                        <thead>
                            <tr>
                                <th data-field="state" data-checkbox="true" data-align="center"></th>
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
                            <strong>Success!</strong> <span id="alert_text"></span>
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