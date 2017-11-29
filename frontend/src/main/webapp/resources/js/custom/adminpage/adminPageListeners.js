$(document).ready(function () {
    var elements = {
        studentsTable : $('#table1'),
        deleteStudentsBtn : $('#delete_students_btn'),
        assignStudentsBtn : $('#assign_students_btn'),
        confirmAssignBtn : $('#assign_student_form_btn'),
        releaseStudentsBtn : $('#release_students_btn')
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

    setSearchFiledPlaceholder();
});
