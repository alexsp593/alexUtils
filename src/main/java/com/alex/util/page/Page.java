package com.alex.util.page;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Deception:分页搜索类
 * @Author:Alex
 * @Date:2018年06月06日10点38分
 */
public class Page<T> extends Pagination {
    private static final long serialVersionUID = 1L;
    private List<T> records;//搜索记录
    private transient Map<String, Object> condition;//搜索条件

    public Page() {
        this.records = Collections.emptyList();
    }

    public Page(int current, int size) {
        super(current, size);
        this.records = Collections.emptyList();
    }

    public Page(int current, int size, String orderByField) {
        super(current, size);
        this.records = Collections.emptyList();
        this.setOrderByField(orderByField);
    }

    public Page(int current, int size, String orderByField, boolean isAsc) {
        this(current, size, orderByField);
        this.setAsc(isAsc);
    }

    public List<T> getRecords() {
        return this.records;
    }

    public Page<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    public Map<String, Object> getCondition() {
        return this.condition;
    }

    public Page<T> setCondition(Map<String, Object> condition) {
        this.condition = condition;
        return this;
    }

    public String toString() {
        StringBuilder pg = new StringBuilder();
        pg.append(" Page:{ [").append(super.toString()).append("], ");
        if(this.records != null) {
            pg.append("records-size:").append(this.records.size());
        } else {
            pg.append("records is null");
        }

        return pg.append(" }").toString();
    }
}
