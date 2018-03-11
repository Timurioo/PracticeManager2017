package com.chekh.pmfrontend.dto.filter;

/**
 * Created by dima on 12/20/2017.
 */
public class SimpleTableFilterDTO {
    private String search;
    private String order;
    private int offset;
    private int limit;

    public SimpleTableFilterDTO() {
    }

    public SimpleTableFilterDTO(String search, String order, int offset, int limit) {
        this.search = search;
        this.order = order;
        this.offset = offset;
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
