package com.learnwy.response;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * date 2017/9/4
 * create by learnwy
 * lis is GPL-3.0
 */
public class Data<T> {
    private Boolean success;
    private List<T> data;
    private Integer total;
    private Integer page;
    private Integer pageSize;
    public Data() {
    }

    public Data(Boolean success, List<T> data, Integer total, Integer page, Integer pageSize) {
        this.success = success;
        this.data = data;
        this.total = total;
        this.page = page;
        this.pageSize = pageSize;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
