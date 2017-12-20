let elements ={};

$(document).ready( function () {

    elements = {
        facultySubmitBtn : $('#submit_faculty_btn'),
        specialitySubmitBtn : $('#submit_speciality_btn'),
        facultyNameInputField: $('#name_faculty'),
        alertModal: $('#alert_modal'),
        alertText: $('#alert_text'),
        alertCloseBtn: $('#alert_close_btn'),
        specialityNameInputField: $('#name_speciality'),
        facultyNameSelectionField: $('#faculties')
    };
    getFaculties();

    elements.facultySubmitBtn.click(function () {
        registrationFacultyAjaxRequest();
    });

    elements.specialitySubmitBtn.click(function () {
        registrationSpecialityAjaxRequest();
    });

});

function registrationFacultyAjaxRequest(){
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/faculties",
        data:JSON.stringify({"name":elements.facultyNameInputField.val()}),
        success: function (data) {

            elements.facultyNameInputField.parent().next(".text-danger").remove();
            if(data.name != null) {
                elements.facultyNameInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.name + "</p>");
            }

            if(!data){
                elements.alertText.html("Faculty");
                elements.alertModal.modal("show");
                elements.alertCloseBtn.click(function () {
                    window.location.replace("/registration/faculty");
                });
            }
        }
    })
}

function registrationSpecialityAjaxRequest(){
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/specialities",
        data:JSON.stringify({"name":elements.specialityNameInputField.val(),
            "facultyId":elements.facultyNameSelectionField.val()}),
        success: function (data) {

            elements.specialityNameInputField.parent().next(".text-danger").remove();
            if(data.name != null) {
                elements.specialityNameInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.name + "</p>");
            }

            elements.facultyNameSelectionField.parent().next(".text-danger").remove();
            if(data.facultyId != null) {
                elements.facultyNameSelectionField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.facultyId + "</p>");
            }

            if(!data){
                elements.alertText.html("Speciality");
                elements.alertModal.modal("show");
                elements.alertCloseBtn.click(function () {
                    window.location.replace("/registration/faculty");
                });
            }
        }
    })
}

function getFaculties() {
    $.ajax({
        url: '/faculties',
        type: 'GET',
        contentType: "application/json; charset=UTF-8",
        data: '',
        success: function (data) {
            for(let i in data) {
                elements.facultyNameSelectionField.append($("<option></option>")
                    .attr("value", data[i].id)
                    .text(data[i].name));
            }
        }
    });
}