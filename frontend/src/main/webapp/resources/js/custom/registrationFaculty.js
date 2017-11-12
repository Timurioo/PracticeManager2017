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
