$(document).ready(function () {

    $('#faculty_form').validate({
        rules:{
            name_f:{
                required: true,
                minlength: 2,
                maxlength: 8,
                lettersonly: true
            }
        },

        messages:{
            name_f:{
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 2.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 8.",
                lettersonly: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only letters."
            }
        }
    });

    $('#faculty_form input').on('keyup blur', function () {
        if ($('#faculty_form').valid()) {
            $('#submit_faculty_btn').prop('disabled', false);
        } else {
            $('#submit_faculty_btn').prop('disabled', 'disabled');
        }
    });

    $('#speciality_form').validate({
        rules:{
            name_s:{
                required: true,
                minlength: 2,
                maxlength: 8,
                lettersonly: true
            },
            faculty_select: {
                required: true
            }
        },

        messages:{
            name_s:{
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 2.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 8.",
                lettersonly: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only letters."
            },
            faculty_select:{
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
            }
        }
    });

    $('#speciality_form input').on('keyup blur', function () {
       validateSpecialityForm();
    });

    $('#speciality_form select').on('change', function () {
        validateSpecialityForm();
    });

});

function validateSpecialityForm() {
    if ($('#speciality_form').valid()) {
        $('#submit_speciality_btn').prop('disabled', false);
    } else {
        $('#submit_speciality_btn').prop('disabled', 'disabled');
    }
}