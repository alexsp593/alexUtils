package com.alex.utils.page;

import java.util.List;

/**
 * @Deception:分页返回值类
 * @Author:Alex
 * @Date:2018年06月06日10点40分
 */
public class PageInfo<T> {

    // 结果集
    private List<T> rows;

    // 总数
    private long total;

    public PageInfo(Page<T> page){
        this.rows = page.getRecords();
        this.total = page.getTotal();
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
