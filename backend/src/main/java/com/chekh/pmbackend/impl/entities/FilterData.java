package com.chekh.pmbackend.impl.entities;

/**
 * Created by dima on 12/6/2017.
 */
public class FilterData {

    private String budget;
    private String status;

    public FilterData() {
    }

    public FilterData(String budget, String status) {
        this.budget = budget;
        this.status = status;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FilterData{" +
                "budget='" + budget + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
