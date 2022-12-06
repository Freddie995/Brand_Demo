package com.gdufs.pojo;

import java.util.List;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/7/1
 */


public class PageBean<T> {
    private int totalCount;
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
