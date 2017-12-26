let assignFormElements={};
$(document).ready(function () {

    assignFormElements = {
        assignForm: $('#assign_form'),
        assignFormSelect: $('#assign_form select'),
        assignFormSubmitBtn: $('#assign_student_form_btn')
    };

    assignFormElements.assignForm.validate({
        rules: {
            practice_request_select_name: {
                required: true
            }
        },

        messages: {
            practice_request_select_name: {
                required: "<span class='glyphicon glyphicon-exclamation-sign'></span> Required field."
            }
        }
    });

    assignFormElements.assignFormSelect.on('change', function () {
        validateAssignForm();
    });

});


function validateAssignForm() {
    if (assignFormElements.assignForm.valid() && assignFormElements.assignFormSelect.val()) {
        assignFormElements.assignFormSubmitBtn.prop('disabled', false);
    } else {
        assignFormElements.assignFormSubmitBtn.prop('disabled', 'disabled');
    }
}
