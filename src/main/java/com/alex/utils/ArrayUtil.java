package com.alex.utils;

/**
 * 数组工具类
 *
 * @author: alex
 * @date: 2018-06-10
 */
public final class ArrayUtil {
    /**
     * 获取一个double类型的数字的小数位有多长
     *
     * @param number double类型数字
     * @return 返回小数位数长度
     */
    public static int doubleBitCount(double number) {
        String temp = String.valueOf(number);
        int i = temp.indexOf(".");
        if (i > -1) {
            return temp.length() - i - 1;
        }
        return 0;
    }

    /**
     * 获取一组double类型的数字的小数位数的数组
     *
     * @param numberArr 一组double类型数字数组
     * @return 返回一组小数位数长度数组
     */
    public static Integer[] doubleBitCount(double[] numberArr) {
        if(numberArr == null){
            return null;
        }
        Integer[] len = new Integer[numberArr.length];
        for (int i = 0; i < numberArr.length; i++) {
            len[i] = doubleBitCount(numberArr[i]);
        }
        return len;
    }
}
