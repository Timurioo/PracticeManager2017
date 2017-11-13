$(document).ready(function () {

    $('#id_practice_form').validate({
        rules: {
            company_name: {
                required: true,
                minlength: 2,
                maxlength: 20,
                letterswithspace: true
            },
            first_d: {
                required: true
            },
            finish_d: {
                required: true
            },
            average_mark: {
                minlength: 1,
                maxlength: 4,
                max: 10,
                min: 1,
                number: true
            },
            total_q: {
                required: true,
                minlength: 1,
                maxlength: 3,
                max: 500,
                min: 1,
                digits: true
            }
        },

        messages: {
            company_name: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 2.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 20.",
                letterswithspace: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only letters."
            },
            first_d: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field."
            },
            finish_d: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field."
            },
            average_mark: {
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 1.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 4.",
                number: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only numbers."
            },
            total_q: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 1.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 4.",
                digits: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only digits."
            }
        }
    });

    $('#id_practice_form input').on('keyup blur', function () {
        if ($('#id_practice_form').valid()) {
            $('#submit_practice_btn').prop('disabled', false);
        } else {
            $('#submit_practice_btn').prop('disabled', 'disabled');
        }
    });
});