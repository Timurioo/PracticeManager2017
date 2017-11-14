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