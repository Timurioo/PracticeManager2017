var elements={};

$(document).ready(function () {
    elements = {
        studentsTable : $('#table1'),
        assignStudentsTable : $('#assign_student_table'),
        deleteStudentsBtn : $('#delete_students_btn'),
        assignStudentsBtn : $('#assign_students_btn'),
        confirmAssignBtn : $('#assign_student_form_btn'),
        releaseStudentsBtn : $('#release_students_btn'),
        practicesSelect : $('#practices_requests_select'),
        assignStudentsModal : $('#assign_modal'),
        alertModal: $('#alert_modal'),
        alertText: $('#alert_text'),
        tableToolbarSearchInput: $('.fixed-table-toolbar .search input'),
        filterSelectForBudget: $('.bootstrap-table-filter-control-budget'),
        filterSelectForStatus: $('.bootstrap-table-filter-control-status')
    };

    elements.deleteStudentsBtn.click(function () {
        deleteStudentAjaxRequest();
    });

    elements.studentsTable.change(function () {
        setDeleteButtonEnable();
        setAssignButtonEnable();
        setReleaseButtonEnable();
    });

    elements.studentsTable.on('search.bs.table', function () {
        elements.studentsTable.bootstrapTable('resetSearch',$('.search').find('input').val());
        clearSelectedRows();
        setDeleteButtonEnable();
        setAssignButtonEnable();
        setReleaseButtonEnable();
    });

    elements.assignStudentsBtn.click(function () {
        loadAssignStudentsTableDate();
    });

    elements.confirmAssignBtn.click(function () {
        assignStudents();
    });

    elements.releaseStudentsBtn.click(function () {
        releaseStudents();
    });

    elements.studentsTable.on('check.bs.table check-all.bs.table ' +
        'uncheck.bs.table uncheck-all.bs.table', function (e, row) {
        selectionManager(e, row);
    });

    elements.studentsTable.on('post-header.bs.table',function () {
        setFilterSelectOptions();
    });

    setSearchFiledPlaceholder();
});

var checkedRows=[];

function setDeleteButtonEnable() {
    var checked = false;
    if(checkedRows.length>0){
        checked= true;
    }

    if(checked){
        elements.deleteStudentsBtn.prop("disabled", false);
    }else{
        elements.deleteStudentsBtn.prop("disabled", "disabled");
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
        elements.releaseStudentsBtn.prop("disabled", false);
    }else{
        elements.releaseStudentsBtn.prop("disabled", "disabled");
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
        elements.assignStudentsBtn.prop("disabled", false);
    }else{
        elements.assignStudentsBtn.prop("disabled", "disabled");
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
            elements.studentsTable.bootstrapTable('refresh');
            setDeleteButtonEnable();
        }
    });
}

function loadAssignStudentsTableDate(){

    elements.assignStudentsTable.bootstrapTable("load", checkedRows);
    getPracticesRequests();
}

function getPracticesRequests() {
    $.ajax({
        url: '/practices/available',
        type: 'GET',
        contentType: "application/json; charset=UTF-8",
        data: '',
        success: function (data) {
            elements.practicesSelect.empty();
            for(var i in data) {
                elements.practicesSelect
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
        practiceId : elements.practicesSelect.val(),
        studentsIds : studentsIds
    };

    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/assignStudents",
        data:JSON.stringify(resultData),
        success: function (data) {
            clearSelectedRows();
            elements.assignStudentsModal.modal('toggle');
            setDeleteButtonEnable();
            setAssignButtonEnable();
            elements.studentsTable.bootstrapTable('refresh');
            elements.alertText.html("Student(s) has been assigned!");
            elements.alertModal.modal("show");
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
            elements.studentsTable.bootstrapTable('refresh');
            elements.alertText.html("Student(s) has been released!");
            elements.alertModal.modal("show");
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

function setSearchFiledPlaceholder() {
    elements.tableToolbarSearchInput.attr('placeholder', 'Fast search ...');
}

function setFilterSelectOptions(){
    if(!elements.filterSelectForStatus.find("option[value='Available']").length){
        elements.filterSelectForStatus.append($("<option value='Available'>Available</option>"));
    }

    if(!elements.filterSelectForStatus.find("option[value='Waiting']").length){
        elements.filterSelectForStatus.append($("<option value='Waiting'>Waiting</option>"));
    }

    if(!elements.filterSelectForStatus.find("option[value='Busy']").length){
        elements.filterSelectForStatus.append($("<option value='Busy'>Busy</option>"));
    }

    if(!elements.filterSelectForBudget.find("option[value='Budget']").length){
        elements.filterSelectForBudget.append($("<option value='Budget'>Budget</option>"));
    }

    if(!elements.filterSelectForBudget.find("option[value='Chargeable']").length){
        elements.filterSelectForBudget.append($("<option value='Chargeable'>Chargeable</option>"));
    }
}
