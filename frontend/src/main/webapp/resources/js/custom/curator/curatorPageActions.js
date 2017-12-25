let elements={};

$(document).ready(function () {
    elements = {
        studentsTable: $('#table1'),
        practicesTable: $('#curator_practices_table'),
        searchInputField: $('.fixed-table-toolbar .search input')
    };
    setCuratorName();
    setTablesDataUrls();
    setSearchFiledPlaceholder();
});

function setTablesDataUrls() {
    let id = getIdParam();

    let studentsOptions = elements.studentsTable.bootstrapTable('getOptions');
    studentsOptions.url = '/students/practiceData/curator/'+id;
    elements.studentsTable.bootstrapTable('refreshOptions', studentsOptions);
    elements.studentsTable.bootstrapTable('refresh');

    let practicesOptions = elements.practicesTable.bootstrapTable('getOptions');
    practicesOptions.url = '/practices/curator/'+id;
    elements.practicesTable .bootstrapTable('refreshOptions', practicesOptions);
    elements.practicesTable .bootstrapTable('refresh');
}

function setCuratorName() {
    $.ajax({
        type: "GET",
        url: '/headOfPractice/'+getIdParam(),
        data: '',
        success: function (data) {
            if(data) {
                console.log(data);
                $('#jumbotron_description').append(" <strong>"+data.name+"</strong>");
            } else {
                window.location.replace("/errors/404");
            }

        }
    });
}

function getIdParam() {
    let s = window.location.href;
    s = s.match(new RegExp('curator' + '\/([^&=]+)'));
    let id= s ? s[1] : null;
    return id;
}

function setSearchFiledPlaceholder() {
    elements.searchInputField.attr('placeholder', 'Fast search ...');
}