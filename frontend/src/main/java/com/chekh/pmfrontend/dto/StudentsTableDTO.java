package com.chekh.pmfrontend.dto;

/**
 * Created by dima on 11/21/2017.
 */
public class StudentsTableDTO {
    private String offset;
    private String limit;
    private String order;

    public StudentsTableDTO() {
    }

    public StudentsTableDTO(String offset, String limit, String order) {
        this.offset = offset;
        this.limit = limit;
        this.order = order;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
