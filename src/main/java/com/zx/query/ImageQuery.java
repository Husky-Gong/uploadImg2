package com.zx.query;

public class ImageQuery {
    private Integer page;
    private Integer limit;
    private String name;

    public ImageQuery(Integer page, Integer limit, String name) {
        this.page = page;
        this.limit = limit;
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
