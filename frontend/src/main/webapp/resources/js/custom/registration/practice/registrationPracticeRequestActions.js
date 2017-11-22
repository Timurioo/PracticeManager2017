function getSpecialities() {
    if(($('#faculties').val())!= "-") {
        $.ajax({
            url: '/faculties/' + $('#faculties').val() + '/specialities',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                $('#specialities').empty();
                $('#specialities')
                    .append($("<option></option>")
                        .attr("value", "-")
                        .text("-"));

                for (var i in data) {
                    $('#specialities')
                        .append($("<option></option>")
                            .attr("value", data[i].id)
                            .text(data[i].name));
                }
            }
        });
    }else{
        $('#specialities').empty();
        $('#specialities')
            .append($("<option></option>")
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

            $('#faculties')
                .append($("<option></option>")
                    .attr("value", "-")
                    .text("-"));

            for(var i in data) {
                $('#faculties')
                    .append($("<option></option>")
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

            for(var i in data) {
                $('#head_of_practices')
                    .append($("<option></option>")
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
        data:JSON.stringify({"company":$('#name_company').val(),
            "headOfPracticeId":$('#head_of_practices').val(),
            "firstDate":$('#first_date').val(),
            "finishDate":$('#finish_date').val(),
            "facultyId":$('#faculties').val(),
            "specialityId":$('#specialities').val(),
            "avrMark":$('#avr_mark').val(),
            "totalQuantity":$('#total_quantity').val()}),
        success: function (data) {

            $('#name_company').parent().next(".text-danger").remove();
            if(data.company != null) {
                $('#name_company').parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.company + "</p>");
            }

            $('#first_date').parent().next(".text-danger").remove();
            if(data.firstDate != null) {
                $('#first_date').parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.firstDate + "</p>");
            }

            $('#finish_date').parent().next(".text-danger").remove();
            if(data.finishDate != null) {
                $('#finish_date').parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.finishDate + "</p>");
            }

            $('#total_quantity').parent().next(".text-danger").remove();
            if(data.totalQuantity != null) {
                $('#total_quantity').parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.totalQuantity + "</p>");
            }

            if(!data){
                $('#alert_text').html("Practice request");
                $('#alert_modal').modal("show");
                $('#alert_close_btn').click(function () {
                    window.location.replace("/registration/practice");
                });
            }
        }
    })
}