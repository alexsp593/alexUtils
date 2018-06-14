package com.alex.utils;

/**
 * @Deception:数组工具类
 * @Author:Alex
 * @Date:2018年06月10日17点51分
 */
public class ArrayUtil {
    /**
     * 获取一个double类型的数字的小数位有多长
     * @param dd
     * @return
     */
    public static int doueleBitCount(double dd){
        String temp = String.valueOf(dd);
        int i = temp.indexOf(".");
        if(i > -1){
            return temp.length()-i -1;
        }
        return 0;

    }

    /**
     * 获取一组double类型的数字的小数位数的数组
     * @param arr
     * @return
     */
    public static Integer[] doubleBitCount(double[] arr){
        Integer[] len = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            len[i] = doueleBitCount(arr[i]);
        }
        return len;
    }
}
