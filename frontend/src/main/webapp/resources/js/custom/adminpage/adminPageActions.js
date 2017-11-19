
var checkedStudentsData;

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
    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=UTF-8",
        url:"/students",
        data:JSON.stringify(getCheckedStudentsId()),
        success: function (data) {
                $('#table1').bootstrapTable('refresh');
                $('#delete_students_btn').prop("disabled", "disabled");
        }
    });
}

function getCheckedStudentsId() {
    var resultId = [];
    $("tr.selected").find("input[checked='checked']:checkbox").each(function () {
        resultId.push($(this).val());
    });
    return resultId;
}

function setCheckBoxesUnselected() {
    $('input:checkbox').prop('checked', false);
    $('tr.selected').prop('class', '');
}

function loadAssignStudentsTableDate(){

    var studentData = [];
    $("tr.selected").each(function () {

        var temp ={
            name: $(this).find('td:nth-child(2)').text()+' '+$(this).find('td:nth-child(3)').text(),
            faculty: $(this).find('td:nth-child(4)').text(),
            speciality: $(this).find('td:nth-child(5)').text(),
            avrMark: $(this).find('td:nth-child(7)').text(),
            studentId: $(this).find("input[checked='checked']:checkbox").val()
        };
        studentData.push(temp);
    });

    //console.log(studentData);
    checkedStudentsData = studentData;
    $('#assign_student_table').bootstrapTable("load", studentData);
    //$('#assign_student_table').bootstrapTable('hideColumn', 'studentId');

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
    for(var i in checkedStudentsData){
        studentsIds.push(checkedStudentsData[i].studentId);
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
    $("tr.selected").each(function () {
        studentsIds.push($(this).find("input[checked='checked']:checkbox").val());
    });

    console.log(studentsIds);

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