package com.netcracker.etalon.beans;

import java.util.List;

/**
 * Created by dima on 11/25/2017.
 */
public class PracticeTableViewModel {

    private int total;
    private List<PracticeViewModel> rows;

    public PracticeTableViewModel() {
    }

    public PracticeTableViewModel(int total, List<PracticeViewModel> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PracticeViewModel> getRows() {
        return rows;
    }

    public void setRows(List<PracticeViewModel> rows) {
        this.rows = rows;
    }
}
