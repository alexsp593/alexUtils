package com.alex.util.page;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Deception:分页类
 * @Author:Alex
 * @Date:2018年06月06日10点10分
 */
public class Pagination extends RowBounds implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient int offset;//起始数
    private transient int limit;//限定数
    private int total;//查询总数
    private int size;//每页数量
    private int pages;//总页数
    private int current;//当前页码
    private transient boolean searchCount;//是否查找总数
    private transient boolean openSort;//是否开启排序
    private transient List<String> ascs;//正序的字段名List
    private transient List<String> descs;//倒叙的字段名List
    private transient boolean isAsc;//是否正序
    private transient String orderByField;//正序的字段

    public Pagination() {
        this.size = 10;
        this.current = 1;
        this.searchCount = true;
        this.openSort = true;
        this.isAsc = true;
    }

    public Pagination(int current, int size) {
        this(current, size, true);
    }

    public Pagination(int current, int size, boolean searchCount) {
        this(current, size, searchCount, true);
    }

    public Pagination(int current, int size, boolean searchCount, boolean openSort) {
        super(offsetCurrent(current, size), size);
        this.size = 10;
        this.current = 1;
        this.searchCount = true;
        this.openSort = true;
        this.isAsc = true;
        this.setOffset(offsetCurrent(current, size));
        this.setLimit(size);
        if(current > 1) {
            this.current = current;
        }

        this.size = size;
        this.searchCount = searchCount;
        this.openSort = openSort;
    }

    protected static int offsetCurrent(int current, int size) {
        return current > 0?(current - 1) * size:0;
    }

    public int offsetCurrent() {
        return offsetCurrent(this.current, this.size);
    }

    public boolean hasPrevious() {
        return this.current > 1;
    }

    public boolean hasNext() {
        return this.current < this.pages;
    }

    public int getTotal() {
        return this.total;
    }

    public Pagination setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getSize() {
        return this.size;
    }

    public Pagination setSize(int size) {
        this.size = size;
        return this;
    }

    public int getPages() {
        if(this.size == 0) {
            return 0;
        } else {
            this.pages = this.total / this.size;
            if(this.total % this.size != 0) {
                ++this.pages;
            }

            return this.pages;
        }
    }

    public int getCurrent() {
        return this.current;
    }

    public Pagination setCurrent(int current) {
        this.current = current;
        return this;
    }

    public boolean isSearchCount() {
        return this.searchCount;
    }

    public Pagination setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
        return this;
    }

    /** @deprecated */
    @Deprecated
    public String getOrderByField() {
        return this.orderByField;
    }

    public Pagination setOrderByField(String orderByField) {
        if(StringUtils.isNotEmpty(orderByField)) {
            this.orderByField = orderByField;
        }

        return this;
    }

    public boolean isOpenSort() {
        return this.openSort;
    }

    public Pagination setOpenSort(boolean openSort) {
        this.openSort = openSort;
        return this;
    }

    public List<String> getAscs() {
        return this.orders(this.isAsc, this.ascs);
    }

    private List<String> orders(boolean condition, List<String> columns) {
        if(condition && StringUtils.isNotEmpty(this.orderByField)) {
            if(columns == null) {
                columns = new ArrayList();
            }

            if(!((List)columns).contains(this.orderByField)) {
                ((List)columns).add(this.orderByField);
            }
        }

        return (List)columns;
    }

    public Pagination setAscs(List<String> ascs) {
        this.ascs = ascs;
        return this;
    }

    public List<String> getDescs() {
        return this.orders(!this.isAsc, this.descs);
    }

    public Pagination setDescs(List<String> descs) {
        this.descs = descs;
        return this;
    }

    /** @deprecated */
    @Deprecated
    public boolean isAsc() {
        return this.isAsc;
    }

    public Pagination setAsc(boolean isAsc) {
        this.isAsc = isAsc;
        return this;
    }

    public int getOffset() {
        return this.offset;
    }

    public Pagination setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public int getLimit() {
        return this.limit;
    }

    public Pagination setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public String toString() {
        return "Pagination { total=" + this.total + " ,size=" + this.size + " ,pages=" + this.pages + " ,current=" + this.current + " }";
    }
}
