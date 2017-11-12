function registrationFacultyAjaxRequest(){
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/faculties",
        data:JSON.stringify({"name":$('#name_faculty').val()}),
        success: function (data) {

            $('#name_faculty').parent().next(".text-danger").remove();
            if(data.name != null) {
                $('#name_faculty').parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.name + "</p>");
            }

            if(!data){
                alert("Faculty successfully was registered!");
                window.location.replace("/registration/faculty");
            }
        }
    })
}

function registrationSpecialityAjaxRequest(){
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/specialities",
        data:JSON.stringify({"name":$('#name_speciality').val(),
            "facultyId":$('#faculties').val()}),
        success: function (data) {

            $('#name_speciality').parent().next(".text-danger").remove();
            if(data.name != null) {
                $('#name_speciality').parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.name + "</p>");
            }

            $('#faculties').parent().next(".text-danger").remove();
            if(data.facultyId != null) {
                $('#faculties').parent().after("<p class='text-danger'><span class='glyphicon glyphicon-ban-circle'></span> " + data.facultyId + "</p>");
            }

            if(!data){
                alert("Speciality successfully was registered!");
                window.location.replace("/registration/faculty");
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
            for(var i in data) {
                $('#faculties')
                    .append($("<option></option>")
                        .attr("value", data[i].id)
                        .text(data[i].name));
            }
        }
    });
}