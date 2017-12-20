let elements = {};

$(document).ready(function () {
    elements={
        nameField: $('#name'),
        surnameField: $('#surname'),
        phoneField: $('#phone'),
        emailField: $('#email'),
        facultyFiled: $('#faculty'),
        specialityField: $('#speciality'),
        groupField: $('#group'),
        budgetField: $('#budget'),
        avrMarkField: $('#avrMark'),
        statusField: $('#status'),
        companyField: $('#company'),
        practicePeriodField: $('#practicePeriod')
    };
    studentProfileDateAjaxLoad();
});

function getIdParam() {
    let s = window.location.href;
    s = s.match(new RegExp('studentProfile' + '\/([^&=]+)'));
    return s ? s[1] : null;
}

function studentProfileDateAjaxLoad() {
    $.ajax({
        type: "GET",
        url: '/students/'+getIdParam(),
        data: '',
        success: function (data) {
            elements.nameField.html("Name: "+data.name);
            elements.surnameField.html("Surname: "+data.surname);
            elements.phoneField.html("Phone: "+data.phone);
            elements.emailField.html("Email: "+data.email);
            elements.facultyFiled.html("Faculty: "+data.faculty);
            elements.specialityField.html("Speciality: "+data.speciality);
            elements.groupField.html("Group: "+data.group);
            elements.budgetField.html("Education basis: "+data.budget);
            elements.avrMarkField.html("Average mark: "+data.avrMark);
            elements.statusField.html("Status: "+data.status);
            if (data.company != null && data.practicePeriod != null){
                elements.companyField.html("Company name: "+data.company);
                elements.practicePeriodField.html("Period of practice: "+data.practicePeriod);
            }else{
                elements.companyField.html("Company name: - ");
                elements.practicePeriodField.html("Period of practice: - ");
            }

        }
    });
}
