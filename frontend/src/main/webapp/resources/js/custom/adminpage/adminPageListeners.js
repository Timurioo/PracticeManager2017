$(document).ready(function () {
    $('#table1').on('load-success.bs.table',function () {
        setCheckBoxesUnselected();
    });

    $('#delete_students_btn').click(function () {
        deleteStudentAjaxRequest();
    });

    $('#table1').change(function () {
        setDeleteButtonEnable();
    });
});
