$(document).ready(function () {
    var elements = {
        studentsTable : $('#table1'),
        deleteStudentsBtn : $('#delete_students_btn'),
        assignStudentsBtn : $('#assign_students_btn'),
        confirmAssignBtn : $('#assign_student_form_btn'),
        releaseStudentsBtn : $('#release_students_btn')
    };

    elements.studentsTable.on('load-success.bs.table',function () {
        setCheckBoxesUnselected();
    });

    elements.deleteStudentsBtn.click(function () {
        deleteStudentAjaxRequest();
    });

    elements.studentsTable.change(function () {
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

});
