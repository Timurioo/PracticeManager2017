$(document).ready( function () {

    getFaculties();

    $('#submit_faculty_btn').click(function () {
        registrationFacultyAjaxRequest();
    });

    $('#submit_speciality_btn').click(function () {
        registrationSpecialityAjaxRequest();
    });

});
