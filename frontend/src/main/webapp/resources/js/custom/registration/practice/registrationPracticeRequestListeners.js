$(document).ready(function () {

    var elements ={
        facultySelection : $('#faculties'),
        practiceSubmitBtn : $('#submit_practice_btn')
    };
    getFaculties();
    getHeadOfPractices();

    elements.facultySelection.change(function () {
       getSpecialities();
    });

    elements.practiceSubmitBtn.click(function () {
        registrationPracticeAjaxRequest();
    });

});
