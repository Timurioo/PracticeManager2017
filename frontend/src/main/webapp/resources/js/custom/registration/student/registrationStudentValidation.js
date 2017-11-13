$(document).ready(function () {

    $('#student_form').validate({
        rules: {
            name_s: {
                required: true,
                minlength: 2,
                maxlength: 20,
                lettersonly: true
            },
            surname_s: {
                required: true,
                minlength: 2,
                maxlength: 20,
                lettersonly: true
            },
            phone_s: {
                required: true,
                minlength: 7,
                maxlength: 11,
                digits: true
            },
            email_s: {
                required: true,
                maxlength: 40,
                email: true
            },
            group_s: {
                required: true,
                minlength: 3,
                maxlength: 15
            },
            avr_mark_s: {
                required: true,
                minlength: 1,
                maxlength: 4,
                number: true,
                min: 1,
                max: 10
            },
            login_s: {
                required: true,
                minlength: 6,
                maxlength: 20,
                alphanumeric: true
            },
            pass_s: {
                required: true,
                minlength: 6,
                maxlength: 20,
                alphanumeric: true
            }
        },

        messages: {
            name_s: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 2.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 20.",
                lettersonly: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only letters."
            },
            surname_s: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 2.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 20.",
                lettersonly: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only letters."
            },
            phone_s: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 7.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 11.",
                digits: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only digits."
            },
            email_s: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 40.",
                email: "<span class='glyphicon glyphicon-exclamation-sign'></span> Uncorrect email address."
            },
            group_s: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 3.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 15."
            },
            avr_mark_s: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 1.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 4.",
                number: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only numbers.",
                min: "<span class='glyphicon glyphicon-exclamation-sign'></span> Should be greater than or equal to 1.",
                max: "<span class='glyphicon glyphicon-exclamation-sign'></span> Should be less than or equal to 10."
            },
            login_s: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 6.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 20.",
                alphanumeric: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only Letters, numbers, and underscores."
            },
            pass_s: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 6.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 20.",
                alphanumeric: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only Letters, numbers, and underscores."
            }
        }
    });

    $('#student_form input').on('keyup blur', function () {
        if ($('#student_form').valid()) {
            $('#submit_student_btn').prop('disabled', false);
        } else {
            $('#submit_student_btn').prop('disabled', 'disabled');
        }
    });

    $('#head_of_practice_form').validate({
        rules:{
            name_h: {
                required: true,
                minlength: 2,
                maxlength: 20,
                letterswithspace: true
            },
            login_h: {
                required: true,
                minlength: 6,
                maxlength: 20,
                alphanumeric: true
            },
            pass_h: {
                required: true,
                minlength: 6,
                maxlength: 20,
                alphanumeric: true
            }
        },

        messages:{
            name_h:{
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 2.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 20.",
                letterswithspace: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only letters."
            },
            login_h: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 6.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 20.",
                alphanumeric: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only Letters, numbers, and underscores."
            },
            pass_h: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field.",
                minlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Min length: 6.",
                maxlength: "<span class='glyphicon glyphicon-exclamation-sign'></span> Max length: 20.",
                alphanumeric: "<span class='glyphicon glyphicon-exclamation-sign'></span> Only Letters, numbers, and underscores."
            }
        }
    });

    $('#head_of_practice_form input').on('keyup blur', function () {
        if ($('#head_of_practice_form').valid()) {
            $('#submit_headofpractice_btn').prop('disabled', false);
        } else {
            $('#submit_headofpractice_btn').prop('disabled', 'disabled');
        }
    });
});