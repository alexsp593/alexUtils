package com.alex.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

/**
 * @Deception:提供一些对象有效性校验的方法
 * @Author:Alex
 * @Date:2018年06月06日21点45分
 */
@SuppressWarnings("rawtypes")
public final class CheckUtil {

    /**
     * 判断字符串是否是符合指定格式的时间
     *
     * @param date   时间字符串
     * @param format 时间格式
     * @return 是否符合
     */
    public static boolean isDate(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断字符串有效性
     *
     * @param str 字符串
     * @return 判断是否有效
     */
    public static boolean valid(String str) {
        return !(str == null || "".equals(str.trim()));
    }

    /**
     * 判断一组字符串是否有效
     *
     * @param strings 字符串数组
     * @return 判断是否有效
     */
    public final static boolean valid(String... strings) {
        if (strings == null) {
            return false;
        }

        for (String str : strings) {
            if (!valid(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个对象是否为空
     *
     * @param object 目标对象
     * @return 如果对象不为空，则为true，反之为false
     */
    public static boolean valid(Object object) {
        return null != object;
    }

    /**
     * 判断一组对象是否有效
     *
     * @param objects 一组对象
     * @return 如果对象不为空并且长度不为0，则为true，反之为false
     */
    public static boolean valid(Object... objects) {
        if (objects != null && objects.length != 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断集合的有效性
     *
     * @param collection 目标集合
     * @return 如果集合不为空，则为true，反之为false
     */
    public static boolean valid(Collection collection) {
        return !(collection == null || collection.isEmpty());
    }

    /**
     * 判断一组集合是否有效
     *
     * @param collections 目标集合组
     * @return 如果集合组不为空，则为true，反之为false
     */
    public static boolean valid(Collection... collections) {
        if (collections == null || collections.length == 0) {
            return false;
        }

        for (Collection collection : collections) {
            if (!valid(collection)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断map是否有效
     *
     * @param map 目标map
     * @return 如果map不为空，则为true，反之为false
     */
    public static boolean valid(Map map) {
        return !(map == null || map.isEmpty());
    }

    /**
     * 判断一组map是否有效
     *
     * @param maps 目标map组
     * @return 是否全部有效
     */
    public final static boolean valid(Map... maps) {
        if (maps == null || maps.length == 0) {
            return false;
        }

        for (Map map : maps) {
            if (!valid(map)) {
                return false;
            }
        }
        return true;
    }
}
