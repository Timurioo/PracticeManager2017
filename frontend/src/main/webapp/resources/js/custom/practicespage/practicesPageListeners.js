$(document).ready(function () {

    var elements = {
        practicesTable : $('#table1'),
        deletePracticeBtn : $('#delete_practices_btn')
    };

    elements.deletePracticeBtn.click(function () {
        deletePracticeAjaxRequest();
    });

    elements.practicesTable.change(function () {
        setDeleteButtonEnable();
    });

    elements.practicesTable.on('check.bs.table check-all.bs.table ' +
        'uncheck.bs.table uncheck-all.bs.table', function (e, row) {
        selectionManager(e, row);
    });
});
