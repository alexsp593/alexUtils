package com.alex.util.page;

/**
 * @Deception:定义起始数与限定数
 * @Author:Alex
 * @Date:2018年06月06日09点50分
 */
public class RowBounds {
    public static final int NO_ROW_OFFSET = 0;
    public static final int NO_ROW_LIMIT = 2147483647;
    public static final RowBounds DEFAULT = new RowBounds();
    private final int offset;//起始数
    private final int limit;//限定数量

    public RowBounds() {
        this.offset = 0;
        this.limit = 2147483647;
    }

    public RowBounds(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getLimit() {
        return this.limit;
    }
}
