package com.netcracker.etalon.beans;

import java.util.List;

/**
 * Created by dima on 11/22/2017.
 */
public class StudentTableViewModel {

    private int total;
    private List<StudentAndPracticeViewModel> rows;

    public StudentTableViewModel() {
    }

    public StudentTableViewModel(int total, List<StudentAndPracticeViewModel> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<StudentAndPracticeViewModel> getRows() {
        return rows;
    }

    public void setRows(List<StudentAndPracticeViewModel> rows) {
        this.rows = rows;
    }
}
