package com.netcracker.etalon.dto.filter;

/**
 * Created by dima on 12/20/2017.
 */
public class FullTableFilterDTO {
    private String search;
    private String order;
    private String sort;
    private String filter;
    private int offset;
    private int limit;

    public FullTableFilterDTO() {
    }

    public FullTableFilterDTO(String search, String order, String sort, String filter, int offset, int limit) {
        this.search = search;
        this.order = order;
        this.sort = sort;
        this.filter = filter;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
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
