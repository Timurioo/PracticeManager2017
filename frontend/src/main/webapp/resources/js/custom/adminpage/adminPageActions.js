let elements={};

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
        loadAssignStudentsTableData();
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

    elements.practicesSelect.change(function () {
        elements.assignStudentsTable.find('tr.success').removeClass("success");
        checkAssignTableRows();
    });

    setSearchFiledPlaceholder();
});

let checkedRows=[];

function setDeleteButtonEnable() {
    let checked = false;
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
    let checked = false;

    for(let i in checkedRows){
        if(checkedRows[i].status=="Available"){
            checked = false;
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
    let checked = false;

    for(let i in checkedRows){
        if(checkedRows[i].status=="Busy" || checkedRows[i].status=="Waiting"){
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

    let studentsIds = [];
    for(let i in checkedRows){
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

function loadAssignStudentsTableData(){

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
            for(let i in data) {
                if( checkedRows.length <= data[i].availableQuantity) {
                    elements.practicesSelect
                        .append($("<option></option>")
                            .attr("value", data[i].id)
                            .attr("faculty", checkNull(data[i].faculty))
                            .attr("speciality", checkNull(data[i].speciality))
                            .attr("avrmark", checkNull(data[i].avrMark))
                            .text(data[i].company + ' (F:' + checkNull(data[i].faculty) + ' S:' + checkNull(data[i].speciality) + ' M:' + checkNull(data[i].avrMark) + ') Available:' + data[i].availableQuantity));
                }
            }
            validateAssignForm();
            checkAssignTableRows();
        }
    });
}

function checkNull(item) {
    return item = (item == null) ? '' : item;
}

function assignStudents() {

    let studentsIds = [];

    for(let i in checkedRows){
        studentsIds.push(checkedRows[i].id);
    }

    let resultData={
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
    let studentsIds = [];

    for(let i in checkedRows){
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

    let datas = $.map(!$.isArray(rows) ? [rows] : rows, function (row) {
            return {id: row.id, name: row.name+' '+row.surname, faculty: row.faculty, speciality: row.speciality, avrMark: row.avrMark, status: row.status};
        }),
        func2 = $.inArray(e.type, ['check', 'check-all']) > -1 ? 'unionBy' : 'differenceBy';

    if($.inArray(e.type, ['check', 'check-all']) > -1) {
        checkedRows = _[func2](checkedRows, datas, 'id');
    }else{
        checkedRows = _[func2](checkedRows, datas, 'id');
    }
}

function responseHandler(res) {

    let selections = [];
    for(let i in checkedRows){
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

    if(!elements.filterSelectForStatus.find("option[value='Passed']").length){
        elements.filterSelectForStatus.append($("<option value='Passed'>Passed</option>"));
    }

    if(!elements.filterSelectForBudget.find("option[value='Budget']").length){
        elements.filterSelectForBudget.append($("<option value='Budget'>Budget</option>"));
    }

    if(!elements.filterSelectForBudget.find("option[value='Chargeable']").length){
        elements.filterSelectForBudget.append($("<option value='Chargeable'>Chargeable</option>"));
    }
}

function checkAssignTableRows() {
    let optionSelector = 'option:selected';
    let rows = elements.assignStudentsTable.bootstrapTable('getData',true);
    let faculty = $(optionSelector, elements.practicesSelect).attr("faculty");
    let speciality = $(optionSelector, elements.practicesSelect).attr("speciality");
    let avrMark = $(optionSelector, elements.practicesSelect).attr("avrmark");
    for(let i in rows){
        if(faculty!=""){
            if(rows[i].faculty != faculty) {
                continue;
            }
        }

        if(speciality!=""){
            if(rows[i].speciality != speciality) {
                continue;
            }
        }

        if(avrMark!=""){
            if(rows[i].avrMark < avrMark) {
                continue;
            }
        }
        elements.assignStudentsTable.find('tr[data-index=' + i + ']').addClass("success");
    }
}