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
            <div class="btn-toolbar">
                <div class="btn-group ">
                    <a href="/registration/practice" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Create request</a>
                    <button id="delete_practices_btn" disabled="disabled" type="submit" class="btn btn-danger"> Delete request  <span class="glyphicon glyphicon-trash"></span></button>
                </div>
            </div>
        </div>

        <br/>
        <div class="container">
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
                   data-id-field="id">
                <thead>
                <tr>
                    <th data-field="state" data-checkbox="true"></th>
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
                    <th data-field="id" data-formatter="LinkFormatter">Edit</th>
                </tr>
                </thead>
            </table>
        </div>

        <script>
            function LinkFormatter(value, row, index) {
                return "<button href=\"#"+value+"\" class=\"btn btn-default btn-block\" data-toggle=\"modal\" data-target=\"#myModal\">Edit <span class=\"glyphicon glyphicon-pencil\"></span></button>";
            }
        </script>

        <br/>
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">x</button>
                        <h4 class="modal-title">Edit request</h4>
                    </div>
                    <div class="modal-body">
                        <h2 class="text-center">Edit request information:</h2>
                        <form>
                            <div class="form-group">
                                <label class="control-label">Choose head of practice:</label>
                                <div>
                                    <select class="form-control">
                                        <option>Surkov K.A.</option>
                                        <option>Smolykova A.A</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Company name:</label>
                                <div>
                                    <input type="text" class="form-control" placeholder="Enter name...">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Start date:</label>
                                <div >
                                    <input type="date" class="form-control" placeholder="Choose date...">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Finish date:</label>
                                <div>
                                    <input type="date" class="form-control" placeholder="Choose date...">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Choose faculty:</label>
                                <div>
                                    <select class="form-control">
                                        <option>-</option>
                                        <option>FSCAN</option>
                                        <option>FCP</option>
                                        <option>FTC</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Choose speciality:</label>
                                <div>
                                    <select class="form-control">
                                        <option>-</option>
                                        <option>ITS</option>
                                        <option>VMSIS</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Average mark:</label>
                                <div>
                                    <input type="text" class="form-control" placeholder="Enter minimum mark...">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Total quantity:</label>
                                <div>
                                    <input type="text" class="form-control" placeholder="*20...">
                                </div>
                            </div>

                            <div>
                                <button type="submit" class="btn btn-primary btn-block">Edit practice request</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>