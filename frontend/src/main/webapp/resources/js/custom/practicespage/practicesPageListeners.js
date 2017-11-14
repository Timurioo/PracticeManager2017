$(document).ready(function () {
    $('#table1').on('load-success.bs.table',function () {
        setCheckBoxesUnselected();
    });

    $('#delete_practices_btn').click(function () {
        deletePracticeAjaxRequest();
    });

    $('#table1').change(function () {
        setDeleteButtonEnable();
    });


});
