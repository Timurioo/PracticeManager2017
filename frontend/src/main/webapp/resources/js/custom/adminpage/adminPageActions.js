
var checkedRows=[];

function setDeleteButtonEnable() {
    var checked = false;
    if(checkedRows.length>0){
        checked= true;
    }

    if(checked){
        $('#delete_students_btn').prop("disabled", false);
    }else{
        $('#delete_students_btn').prop("disabled", "disabled");
    }
}

function setReleaseButtonEnable() {
    var checked = false;

    for(var i in checkedRows){
        if(checkedRows[i].status=="Available"){
            checked=false;
            break;
        }else {
            checked = true;
        }
    }

    if(checked){
        $('#release_students_btn').prop("disabled", false);
    }else{
        $('#release_students_btn').prop("disabled", "disabled");
    }
}

function setAssignButtonEnable() {
    var checked = false;

    for(var i in checkedRows){
        if(checkedRows[i].status=="Busy"){
            checked=false;
            break;
        }else {
            checked = true;
        }
    }

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
            clearSelectedRows();
            $('#table1').bootstrapTable('refresh');
            setDeleteButtonEnable();
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
            clearSelectedRows();
            $('#assign_modal').modal('toggle');
            setDeleteButtonEnable();
            setAssignButtonEnable();
            $('#table1').bootstrapTable('refresh');
            $('#alert_text').html("Student(s) has been assigned!");
            $('#alert_modal').modal("show");
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
            clearSelectedRows();
            setDeleteButtonEnable();
            setReleaseButtonEnable();
            $('#table1').bootstrapTable('refresh');
            $('#alert_text').html("Student(s) has been released!");
            $('#alert_modal').modal("show");
        }
    })
}

function clearSelectedRows() {
    checkedRows = [];
}

function selectionManager(e, rows) {

        var datas = $.map(!$.isArray(rows) ? [rows] : rows, function (row) {
                return {id: row.id, name: row.name+' '+row.surname, faculty: row.faculty, speciality: row.speciality, avrMark: row.avrMark, status: row.status};
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