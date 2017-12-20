package com.netcracker.pmbackend.interfaces.table;

import com.netcracker.pmbackend.impl.entities.StudentTableData;

/**
 * Created by dima on 12/20/2017.
 */
public interface StudentTableDataService {
    StudentTableData getActualTableData(String search, String filter, String sort, String order, int limit, int offset);
}
