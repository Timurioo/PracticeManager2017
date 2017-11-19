$(document).ready(function () {

    var elements ={
        facultySelection : $('#faculty_name_student'),
        studentSubmitBtn : $('#submit_student_btn'),
        headOfPracticeSubmitBtn : $('#submit_headofpractice_btn')
    };
    getFaculties();

    elements.facultySelection.change(function(){
        getSpecialities()
    });

    elements.studentSubmitBtn.click(function(){
        registrationStudentAjaxRequest()
    });

    elements.headOfPracticeSubmitBtn.click(function(){
        registrationHeadOfPracticeAjaxRequest()
    });


});
