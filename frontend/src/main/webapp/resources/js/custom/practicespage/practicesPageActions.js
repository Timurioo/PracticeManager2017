let elements={};

$(document).ready(function () {

    elements = {
        practicesTable : $('#table1'),
        deletePracticeBtn : $('#delete_practices_btn'),
        searchInputField: $('.fixed-table-toolbar .search input')
    };

    elements.deletePracticeBtn.click(function () {
        deletePracticeAjaxRequest();
    });

    elements.practicesTable.on('search.bs.table', function () {
        clearSelectedRows();
        setDeleteButtonEnable();
    });

    elements.practicesTable.change(function () {
        setDeleteButtonEnable();
    });

    elements.practicesTable.on('check.bs.table check-all.bs.table ' +
        'uncheck.bs.table uncheck-all.bs.table', function (e, row) {
        selectionManager(e, row);
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
        elements.deletePracticeBtn.prop("disabled", false);
    }else{
        elements.deletePracticeBtn.prop("disabled", "disabled");
    }
}

function deletePracticeAjaxRequest(){
    $.ajax({
        type: "DELETE",
        contentType: "application/json; charset=UTF-8",
        url:"/practices",
        data:JSON.stringify(getCheckedPracticesId()),
        success: function (data) {
            clearSelectedRows();
            elements.practicesTable.bootstrapTable('refresh');
            setDeleteButtonEnable();
        }
    });
}

function getCheckedPracticesId() {
    let selections = [];
    for(let i in checkedRows){
        selections.push(checkedRows[i].id);
    }
    return selections;
}

function selectionManager(e, rows) {

    let data = $.map(!$.isArray(rows) ? [rows] : rows, function (row) {
            return {id: row.id};
        }),
        func2 = $.inArray(e.type, ['check', 'check-all']) > -1 ? 'union' : 'differenceBy';

    if($.inArray(e.type, ['check', 'check-all']) > -1) {
        checkedRows = _[func2](checkedRows, data);
    }else{
        checkedRows = _[func2](checkedRows, data, 'id');
    }
    console.log(checkedRows);
}

function clearSelectedRows() {
    checkedRows = [];
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
    elements.searchInputField.attr('placeholder', 'Fast search ...');
}