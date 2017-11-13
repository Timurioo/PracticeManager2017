$(document).ready(function () {

    getFaculties();
    getHeadOfPractices();

    $('#faculties').change(function () {
       getSpecialities();
    });

    $('#submit_practice_btn').click(function () {
        registrationPracticeAjaxRequest();
    });

});
