package com.demo.framework.core.model;

import java.util.List;

/**
 * @author 袁进勇
 *
 */
public class Page<T> {
    private Integer totalCount = 0;
    private Integer pageSize = 10;
    private Integer pageNo = 0; // 从0开始编号，0为第一页
    private String orderBy;
    private List<T> items;

    public Page() {
        this(10, 0);
    }

    public Page(String orderBy) {
        this(10, 0, null);
    }

    public Page(List<T> items) {
        this(items, null);
    }

    public Page(List<T> items, String orderBy) {
        this.pageNo = 0;
        this.pageSize = 0;
        this.totalCount = items.size();
        this.items = items;
        this.orderBy = orderBy;
    }

    public Page(Integer pageSize, Integer currentPage) {
        this(pageSize, currentPage, null);
    }

    public Page(Integer pageSize, Integer currentPage, String orderBy) {
        this.pageSize = pageSize;
        this.pageNo = currentPage;
        this.orderBy = orderBy;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalSize) {
        this.totalCount = totalSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer currentPage) {
        this.pageNo = currentPage;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
