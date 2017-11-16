$(document).ready(function () {
    var elemets = {

    };

    $('#table1').on('load-success.bs.table',function () {
        setCheckBoxesUnselected();
    });

    $('#delete_students_btn').click(function () {
        deleteStudentAjaxRequest();
    });

    $('#table1').change(function () {
        setDeleteButtonEnable();
        setAssignButtonEnable();
    });

    $('#assign_students_btn').click(function () {
        loadAssignStudentsTableDate();
    });

    $('#assign_student_form_btn').click(function () {
        assignStudents();
    });
});
