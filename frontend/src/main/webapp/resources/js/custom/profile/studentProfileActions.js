function getIdParam() {
    var s = window.location.href;
    s = s.match(new RegExp('studentProfile' + '\/([^&=]+)'));
    return s ? s[1] : null;
}

function studentProfileDateAjaxLoad() {
    $.ajax({
        url: '/studentProfileData',
        data: ({id:getIdParam()}),
        success: function (data) {
            $('#name').html("Name: "+data.name);
            $('#surname').html("Surname: "+data.surname);
            $('#phone').html("Phone: "+data.phone);
            $('#email').html("Name: "+data.email);
            $('#faculty').html("Faculty: "+data.faculty);
            $('#speciality').html("Speciality: "+data.speciality);
            $('#group').html("Group: "+data.group);
            $('#budget').html("Education basis: "+data.budget);
            $('#avrMark').html("Average mark: "+data.avrMark);
            $('#status').html("Status: "+data.status);
            if (data.company != null && data.practicePeriod != null){
                $('#company').html("Company name: "+data.company);
                $('#practicePeriod').html("Period of practice: "+data.practicePeriod);
            }else{
                $('#company').html("Company name: - ");
                $('#practicePeriod').html("Period of practice: - ");
            }

        }
    });
}
