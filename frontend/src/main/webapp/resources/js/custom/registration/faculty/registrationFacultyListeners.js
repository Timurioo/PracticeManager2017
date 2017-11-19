$(document).ready( function () {

    var elements = {
        facultySubmitBtn : $('#submit_faculty_btn'),
        specialitySubmitBtn : $('#submit_speciality_btn')
    };
    getFaculties();

    elements.facultySubmitBtn.click(function () {
        registrationFacultyAjaxRequest();
    });

    elements.specialitySubmitBtn.click(function () {
        registrationSpecialityAjaxRequest();
    });

});
