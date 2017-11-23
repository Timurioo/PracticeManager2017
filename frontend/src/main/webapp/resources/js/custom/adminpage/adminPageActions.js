
var checkedRows=[];

function setDeleteButtonEnable() {
    var checked = false;
    $("tr.selected").each(function () {
        checked=true;
    });

    if(checked){
        $('#delete_students_btn').prop("disabled", false);
    }else{
        $('#delete_students_btn').prop("disabled", "disabled");
    }
}

function setReleaseButtonEnable() {
    var checked = false;
    $("tr.selected").each(function () {
        if($(this).find('td:nth-child(8)').text()=="Available"){
            checked=false;
            return false;
        }else {
            checked = true;
        }
    });

    if(checked){
        $('#release_students_btn').prop("disabled", false);
    }else{
        $('#release_students_btn').prop("disabled", "disabled");
    }
}

function setAssignButtonEnable() {
    var checked = false;
    $("tr.selected").each(function () {
        if($(this).find('td:nth-child(8)').text()=="Busy"){
            checked=false;
            return false;
        }else {
            checked = true;
        }
    });

    if(checked){
        $('#assign_students_btn').prop("disabled", false);
    }else{
        $('#assign_students_btn').prop("disabled", "disabled");
    }
}

function deleteStudentAjaxRequest(){

    var studentsIds = [];
    for(var i in checkedRows){
        studentsIds.push(checkedRows[i].id);
    }

    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=UTF-8",
        url:"/students",
        data:JSON.stringify(studentsIds),
        success: function (data) {
                $('#table1').bootstrapTable('refresh');
                $('#delete_students_btn').prop("disabled", "disabled");
        }
    });
}

function loadAssignStudentsTableDate(){

    $('#assign_student_table').bootstrapTable("load", checkedRows);
    getPracticesRequests();
}

function getPracticesRequests() {
    $.ajax({
        url: '/practices/available',
        type: 'GET',
        contentType: "application/json; charset=UTF-8",
        data: '',
        success: function (data) {
            $('#practices_requests_select').empty();
            for(var i in data) {
                $('#practices_requests_select')
                    .append($("<option></option>")
                        .attr("value", data[i].id)
                        .text(data[i].company+' (F:'+checkNull(data[i].faculty)+' S:'+checkNull(data[i].speciality)+' M:'+checkNull(data[i].avrMark)+') Available:'+data[i].availableQuantity));
            }
        }
    });
}

function checkNull(item) {
    return item = (item == null) ? '' : item;
}

function assignStudents() {

    var studentsIds = [];

    for(var i in checkedRows){
        studentsIds.push(checkedRows[i].id);
    }

    var resultData={
        practiceId : $('#practices_requests_select').val(),
        studentsIds : studentsIds
    };

     $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/assignStudents",
        data:JSON.stringify(resultData),
        success: function (data) {

            $('#assign_modal').modal('toggle');
            $('#delete_students_btn').prop("disabled", "disabled");
            $('#assign_students_btn').prop("disabled", "disabled");
            $('#table1').bootstrapTable('refresh');

            $('#table1').on('load-success.bs.table',alert("Student has been successfully assigned!"));


        }
    })
}

function releaseStudents() {
    var studentsIds = [];

    for(var i in checkedRows){
        studentsIds.push(checkedRows[i].id);
    }

    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=UTF-8",
        url:"/assignStudents",
        data:JSON.stringify(studentsIds),
        success: function (data) {

            $('#delete_students_btn').prop("disabled", "disabled");
            $('#assign_students_btn').prop("disabled", "disabled");
            $('#table1').bootstrapTable('refresh');

            $('#table1').on('load-success.bs.table',alert("Student has been successfully released!"));
        }
    })
}

function selectionsManager(e, rows) {

        var datas = $.map(!$.isArray(rows) ? [rows] : rows, function (row) {
                return {id: row.id, name: row.name+' '+row.surname, faculty: row.faculty, speciality: row.speciality, avrMark: row.avrMark};
            }),
            func2 = $.inArray(e.type, ['check', 'check-all']) > -1 ? 'union' : 'differenceBy';

        if($.inArray(e.type, ['check', 'check-all']) > -1) {
            checkedRows = _[func2](checkedRows, datas);
        }else{
            checkedRows = _[func2](checkedRows, datas, 'id');
        }
        console.log(checkedRows);
}

function responseHandler(res) {

    var selections = [];
    for(var i in checkedRows){
        selections.push(checkedRows[i].id);
    }

    $.each(res.rows, function (i, row) {
        row.state = $.inArray(row.id, selections) !== -1;
    });
    return res;
}