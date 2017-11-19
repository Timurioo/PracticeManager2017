$(document).ready(function () {

    var elements = {
        practicesTable : $('#table1'),
        deletePracticeBtn : $('#delete_practices_btn')
    };

    elements.practicesTable.on('load-success.bs.table',function () {
        setCheckBoxesUnselected();
    });

    elements.deletePracticeBtn.click(function () {
        deletePracticeAjaxRequest();
    });

    elements.deletePracticeBtn.change(function () {
        setDeleteButtonEnable();
    });


});
