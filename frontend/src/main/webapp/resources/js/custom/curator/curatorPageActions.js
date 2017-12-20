var elements={};

$(document).ready(function () {
    elements = {
        studentsTable: $('#table1'),
        practicesTable: $('#curator_practices_table'),
        searchInputField: $('.fixed-table-toolbar .search input')
    };

    setTablesDataUrls();
    setSearchFiledPlaceholder();
});

function setTablesDataUrls() {
    var s = window.location.href;
    s = s.match(new RegExp('curator' + '\/([^&=]+)'));
    var id= s ? s[1] : null;

    var studentsOptions = elements.studentsTable.bootstrapTable('getOptions');
    studentsOptions.url = '/students/practiceData/curator/'+id;
    elements.studentsTable.bootstrapTable('refreshOptions', studentsOptions);
    elements.studentsTable.bootstrapTable('refresh');

    var practicesOptions = elements.practicesTable.bootstrapTable('getOptions');
    practicesOptions.url = '/practices/curator/'+id;
    elements.practicesTable .bootstrapTable('refreshOptions', practicesOptions);
    elements.practicesTable .bootstrapTable('refresh');
}

function setSearchFiledPlaceholder() {
    elements.searchInputField.attr('placeholder', 'Fast search ...');
}