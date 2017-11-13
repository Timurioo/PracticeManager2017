$(document).ready(function () {

    getFaculties();

    $('#faculty_name_student').change(function(){
        getSpecialities()
    });

    $('#submit_student_btn').click(function(){
        registrationStudentAjaxRequest()
    });

    $('#submit_headofpractice_btn').click(function(){
        registrationHeadOfPracticeAjaxRequest()
    });


});
