function setDeleteButtonEnable() {
    var checked = false;
    $("tr.selected").each(function () {
        checked=true;
    });

    if(checked){
        $('#delete_practices_btn').prop("disabled", false);
    }else{
        $('#delete_practices_btn').prop("disabled", "disabled");
    }
}

function deletePracticeAjaxRequest(){
    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=UTF-8",
        url:"/practices",
        data:JSON.stringify(getCheckedPracticesId()),
        success: function (data) {
            $('#table1').bootstrapTable('refresh');
            $('#delete_practices_btn').prop("disabled", "disabled");
        }
    });
}

function getCheckedPracticesId() {
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
