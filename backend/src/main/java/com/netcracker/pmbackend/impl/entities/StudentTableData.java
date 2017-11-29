package com.netcracker.pmbackend.impl.entities;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;

import java.util.List;

/**
 * Created by dima on 11/29/2017.
 */
public class StudentTableData {

    private List<StudentsEntity> rowsData;
    private int totalRows;

    public StudentTableData() {
    }

    public StudentTableData(List<StudentsEntity> rowsData, int totalRows) {
        this.rowsData = rowsData;
        this.totalRows = totalRows;
    }

    public List<StudentsEntity> getRowsData() {
        return rowsData;
    }

    public void setRowsData(List<StudentsEntity> rowsData) {
        this.rowsData = rowsData;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
}
