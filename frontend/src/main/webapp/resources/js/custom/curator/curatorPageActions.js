function setTablesDataUrls() {
    var s = window.location.href;
    s = s.match(new RegExp('curator' + '\/([^&=]+)'));
    id= s ? s[1] : null;

    var $studentsTable = $('#table1');
    var studentsOptions = $studentsTable.bootstrapTable('getOptions');
    studentsOptions.url = '/studentsAndPracticeData/curator/'+id;
    $studentsTable.bootstrapTable('refreshOptions', studentsOptions);
    $studentsTable.bootstrapTable('refresh');

    var $practicesTable = $('#curator_practices_table');
    var practicesOptions = $practicesTable.bootstrapTable('getOptions');
    practicesOptions.url = '/practices/curator/'+id;
    $practicesTable .bootstrapTable('refreshOptions', practicesOptions);
    $practicesTable .bootstrapTable('refresh');
}