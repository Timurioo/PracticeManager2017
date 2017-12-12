var elements = {};

$(document).ready(function () {

    elements ={
        facultyNameSelectionField : $('#faculty_name_student'),
        specialityNameSelectionField : $('#speciality_name_student'),
        studentSubmitBtn : $('#submit_student_btn'),
        headOfPracticeSubmitBtn : $('#submit_headofpractice_btn'),
        headOfPracticeLoginInputField : $('#login_headofpractice'),
        headOfPracticePasswordInputField : $('#password_headofpractice'),
        headOfPracticeNameInputField : $('#name_headofpractice'),
        studentLoginInputField : $('#login_student'),
        studentPasswordInputField : $('#password_student'),
        studentNameInputField : $('#name_student'),
        studentSurnameInputField : $('#surname_student'),
        studentPhoneInputField : $('#phone_student'),
        studentEmailInputField : $('#email_student'),
        studentGroupInputField : $('#group_student'),
        studentAvrMarkInputField : $('#average_mark_student'),
        studentBudgetRadioBtnField : $('#radio_Form'),
        studentBudgetRadioBtnCheckedField : $("#radio_Form input[type='radio']:checked"),
        alertModal: $('#alert_modal'),
        alertText: $('#alert_text'),
        alertCloseBtn: $('#alert_close_btn')
    };
    getFaculties();

    elements.facultyNameSelectionField.change(function(){
        getSpecialities()
    });

    elements.studentSubmitBtn.click(function(){
        registrationStudentAjaxRequest()
    });

    elements.headOfPracticeSubmitBtn.click(function(){
        registrationHeadOfPracticeAjaxRequest()
    });

});

function registrationHeadOfPracticeAjaxRequest() {
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/headOfPracticeRegistration",
        data:JSON.stringify({"login":elements.headOfPracticeLoginInputField.val(),
            "password":$.md5(elements.headOfPracticePasswordInputField.val()),
            "role":"ROLE_HEADOFPRACTICE",
            "name":elements.headOfPracticeNameInputField.val()}),
        success: function (data) {


            elements.headOfPracticePasswordInputField.parent().next(".text-danger").remove();
            if(data.password != null) {
                elements.headOfPracticePasswordInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.password + "</p>");
            }

            elements.headOfPracticeLoginInputField.parent().next(".text-danger").remove();
            if(data.login != null) {
                elements.headOfPracticeLoginInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.login + "</p>");
            }

            elements.headOfPracticeNameInputField.parent().next(".text-danger").remove();
            if(data.name != null) {
                elements.headOfPracticeNameInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.name + "</p>");
            }

            if(!data){
                elements.alertText.html("Head of practice");
                elements.alertModal.modal("show");
                elements.alertCloseBtn.click(function () {
                    window.location.replace("/registration");
                });
            }
        }
    })
}

function registrationStudentAjaxRequest() {
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/studentRegistration",
        data:JSON.stringify({"login":elements.studentLoginInputField.val(),
            "password":$.md5(elements.studentPasswordInputField.val()),
            "role":"ROLE_STUDENT",
            "name":elements.studentNameInputField.val(),
            "surname":elements.studentSurnameInputField.val(),
            "phone":elements.studentPhoneInputField.val(),
            "email":elements.studentEmailInputField.val(),
            "facultyId":elements.facultyNameSelectionField.val(),
            "specialityId":elements.specialityNameSelectionField.val(),
            "group":elements.studentGroupInputField.val(),
            "avrMark":elements.studentAvrMarkInputField.val(),
            "budget":elements.studentBudgetRadioBtnCheckedField.val()}),
        success: function (data) {


            elements.studentPasswordInputField.parent().next(".text-danger").remove();
            if(data.password != null) {
                elements.studentPasswordInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.password + "</p>");
            }

            elements.studentLoginInputField.parent().next(".text-danger").remove();
            if(data.login != null) {
                elements.studentLoginInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.login + "</p>");
            }

            elements.studentNameInputField.parent().next(".text-danger").remove();
            if(data.name != null) {
                elements.studentNameInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.name + "</p>");
            }

            elements.studentSurnameInputField.parent().next(".text-danger").remove();
            if(data.surname != null) {
                elements.studentSurnameInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.surname + "</p>");
            }

            elements.studentPhoneInputField.parent().next(".text-danger").remove();
            if(data.phone != null) {
                elements.studentPhoneInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.phone + "</p>");
        }

            elements.studentEmailInputField.parent().next(".text-danger").remove();
            if(data.email != null) {
                elements.studentEmailInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.email + "</p>");
            }

            elements.facultyNameSelectionField.parent().next(".text-danger").remove();
            if(data.facultyId != null) {
                elements.facultyNameSelectionField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.facultyId + "</p>");
            }

            elements.specialityNameSelectionField.parent().next(".text-danger").remove();
            if(data.specialityId != null) {
                elements.specialityNameSelectionField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.specialityId + "</p>");
            }

            elements.studentGroupInputField.parent().next(".text-danger").remove();
            if(data.group != null) {
                elements.studentGroupInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.group + "</p>");
            }

            elements.studentAvrMarkInputField.parent().next(".text-danger").remove();
            if(data.avrMark != null) {
                elements.studentAvrMarkInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.avrMark + "</p>");
            }

            elements.studentBudgetRadioBtnField.parent().next(".text-danger").remove();
            if(data.budget != null) {
                elements.studentBudgetRadioBtnField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.budget + "</p>");
            }

            if(!data){
                elements.alertText.html("Student");
                elements.alertModal.modal("show");
                elements.alertCloseBtn.click(function () {
                    window.location.replace("/registration");
                });
            }

        }
    })
}

function getSpecialities() {
    $.ajax({
        url: 'faculties/'+elements.facultyNameSelectionField.val()+'/specialities',
        type: 'GET',
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            elements.specialityNameSelectionField.empty();
            for(var i in data) {
                elements.specialityNameSelectionField.append($("<option></option>")
                        .attr("value", data[i].id)
                        .text(data[i].name));
            }
        }
    });
}

function getFaculties() {
    $.ajax({
        url: '/faculties',
        type: 'GET',
        contentType: "application/json; charset=UTF-8",
        data: '',
        success: function (data) {
            for(var i in data) {
                elements.facultyNameSelectionField.append($("<option></option>")
                        .attr("value", data[i].id)
                        .text(data[i].name));
            }
            getSpecialities();
        }
    });
}


