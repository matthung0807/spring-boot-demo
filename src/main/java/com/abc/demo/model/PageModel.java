package com.abc.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class PageModel<T> {

    public PageModel(List<T> data) {
        this.data = data;
    }

    private List<T> data;
    private long totalItems;
    private long totalPages;
}
