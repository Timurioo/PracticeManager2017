<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create request</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>
    </head>
    <body>
        <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

        <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
            <jsp:param name="pageTitle" value="Creation request page"/>
            <jsp:param name="titleDescription" value="Fill all text-fields to continue creation in right way."/>
        </jsp:include>

        <div class="container">
            <h2 class="text-center">Creation information:</h2>
            <form class="form-horizontal">

                <div class="form-group">
                    <label class="control-label col-md-4">Choose head of practice:</label>
                    <div class="col-md-4">
                        <select class="form-control">
                            <option>Surkov K.A.</option>
                            <option>Smolykova A.A</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Company name:</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="Enter name...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Start date:</label>
                    <div class="col-md-4">
                        <input type="date" class="form-control" placeholder="Choose date...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Finish date:</label>
                    <div class="col-md-4">
                        <input type="date" class="form-control" placeholder="Choose date...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Choose faculty:</label>
                    <div class="col-md-4">
                        <select class="form-control">
                            <option>-</option>
                            <option>FSCAN</option>
                            <option>FCP</option>
                            <option>FTC</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Choose speciality:</label>
                    <div class="col-md-4">
                        <select class="form-control">
                            <option>-</option>
                            <option>ITS</option>
                            <option>VMSIS</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Average mark:</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="Enter minimum mark...">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-4">Total quantity:</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="*20...">
                    </div>
                </div>

                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-plus"></span> Create practice request</button>
                </div>
            </form>
        </div>

        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>