let elements = {};

$(document).ready(function () {

    elements ={
        facultyNameSelectionField : $('#faculties'),
        specialityNameSelectionField : $('#specialities'),
        companyNameInputField: $('#name_company'),
        headOfPracticeSelectionField: $('#head_of_practices'),
        startDateInputFiled: $('#first_date'),
        finishDateInputField: $('#finish_date'),
        avrMarkInputField: $('#avr_mark'),
        totalQuantityInputField: $('#total_quantity'),
        practiceSubmitBtn : $('#submit_practice_btn'),
        alertModal: $('#alert_modal'),
        alertText: $('#alert_text'),
        alertCloseBtn: $('#alert_close_btn')
    };
    getFaculties();
    getHeadOfPractices();

    elements.facultyNameSelectionField.change(function () {
        getSpecialities();
    });

    elements.practiceSubmitBtn.click(function () {
        registrationPracticeAjaxRequest();
    });

    elements.alertCloseBtn.click(function () {
        window.location.replace("/registration/practice");
    });

    elements.alertModal.on('hidden.bs.modal', function () {
        window.location.replace("/registration/practice");
    })

});


function getSpecialities() {
    if((elements.facultyNameSelectionField.val())!= "-") {
        $.ajax({
            url: '/faculties/' + elements.facultyNameSelectionField.val() + '/specialities',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                elements.specialityNameSelectionField.empty();
                elements.specialityNameSelectionField.append($("<option></option>")
                        .attr("value", "-")
                        .text("-"));

                for (let i in data) {
                    elements.specialityNameSelectionField.append($("<option></option>")
                            .attr("value", data[i].id)
                            .text(data[i].name));
                }
            }
        });
    }else{
        elements.specialityNameSelectionField.empty();
        elements.specialityNameSelectionField.append($("<option></option>")
                .attr("value", "-")
                .text("-"));
    }
}

function getFaculties() {
    $.ajax({
        url: '/faculties',
        type: 'GET',
        contentType: "application/json; charset=UTF-8",
        data: '',
        success: function (data) {

            elements.facultyNameSelectionField.append($("<option></option>")
                    .attr("value", "-")
                    .text("-"));

            for(let i in data) {
                elements.facultyNameSelectionField.append($("<option></option>")
                        .attr("value", data[i].id)
                        .text(data[i].name));
            }

            getSpecialities();
        }
    });
}

function getHeadOfPractices() {
    $.ajax({
        url: '/headOfPractice',
        type: 'GET',
        contentType: "application/json; charset=UTF-8",
        data: '',
        success: function (data) {

            for(let i in data) {
                elements.headOfPracticeSelectionField.append($("<option></option>")
                        .attr("value", data[i].id)
                        .text(data[i].name));
            }
        }
    });
}

function registrationPracticeAjaxRequest() {
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/practices",
        data:JSON.stringify({"company":elements.companyNameInputField.val(),
            "headOfPracticeId":elements.headOfPracticeSelectionField.val(),
            "firstDate":elements.startDateInputFiled.val(),
            "finishDate":elements.finishDateInputField.val(),
            "facultyId":elements.facultyNameSelectionField.val(),
            "specialityId":elements.specialityNameSelectionField.val(),
            "avrMark":elements.avrMarkInputField.val(),
            "totalQuantity":elements.totalQuantityInputField.val()}),
        success: function (data) {

            elements.companyNameInputField.parent().next(".text-danger").remove();
            if(data.company != null) {
                elements.companyNameInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.company + "</p>");
            }

            elements.startDateInputFiled.parent().next(".text-danger").remove();
            if(data.firstDate != null) {
                elements.startDateInputFiled.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.firstDate + "</p>");
            }

            elements.finishDateInputField.parent().next(".text-danger").remove();
            if(data.finishDate != null) {
                elements.finishDateInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.finishDate + "</p>");
            }

            elements.totalQuantityInputField.parent().next(".text-danger").remove();
            if(data.totalQuantity != null) {
                elements.totalQuantityInputField.parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.totalQuantity + "</p>");
            }

            if(!data){
                elements.alertText.html("Practice request");
                elements.alertModal.modal("show");
            }
        }
    })
}