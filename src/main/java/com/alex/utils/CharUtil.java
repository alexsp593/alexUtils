package com.alex.utils;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 各种字符和字符序列实用程序包括字符数组、字节数组转换。
 *
 * @author alex
 * @date 2018-06-14
 */
public final class CharUtil {

    /**
     * 将有符号的字节转换为无符号的字符
     *
     * @param b 有符号的字节
     * @return 无符号字符
     */
    public static char toChar(byte b) {
        return (char) (b & 0xFF);
    }

    /**
     * 通过剥离每个字符的高位字节，将字符数组转换为字节数组
     *
     * @param carr 字符数组
     * @return 字节数组
     */
    public static byte[] toSimpleByteArray(char[] carr) {
        if (carr == null) {
            return null;
        }

        byte[] barr = new byte[carr.length];
        for (int i = 0; i < carr.length; i++) {
            barr[i] = (byte) carr[i];
        }
        return barr;
    }

    /**
     * 将字符序列转换为字节数组
     *
     * @param charSequence 字符序列
     * @return 字节数组
     */
    public static byte[] toSimpleByteArray(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }

        byte[] barr = new byte[charSequence.length()];
        for (int i = 0; i < barr.length; i++) {
            barr[i] = (byte) charSequence.charAt(i);
        }
        return barr;
    }

    /**
     * 将字节数组转换为字符数组
     *
     * @param barr 字节数组
     * @return 字符数组
     */
    public static char[] toSimpleCharArray(byte[] barr) {
        if (barr == null) {
            return null;
        }

        char[] carr = new char[barr.length];
        for (int i = 0; i < barr.length; i++) {
            carr[i] = (char) (barr[i] & 0xFF);
        }
        return carr;
    }

    /**
     * 返回字符的ASCII值。在过载情况下，返回0x3f
     *
     * @param c 字符
     * @return 字符的ASCII值
     */
    public static int toAscii(char c) {
        if (c <= 0xFF) {
            return c;
        } else {
            return 0x3F;
        }
    }

    /**
     * 将字符数组转换为对应ASCII码的数组
     *
     * @param carr 字符数组
     * @return 对应ASCII码的数组
     */
    public static byte[] toAsciiByteArray(char[] carr) {
        if (carr == null) {
            return null;
        }

        byte[] barr = new byte[carr.length];
        for (int i = 0; i < carr.length; i++) {
            barr[i] = (byte) toAscii(carr[i]);
        }
        return barr;
    }

    /**
     * 将字符序列转换为ASCII字节数组
     *
     * @param charSequence 字符序列
     * @return ASCII字节数组
     */
    public static byte[] toAsciiByteArray(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }

        byte[] barr = new byte[charSequence.length()];
        for (int i = 0; i < barr.length; i++) {
            char c = charSequence.charAt(i);
            barr[i] = (byte) toAscii(c);
        }
        return barr;
    }

    /**
     * 将字符数组转换为字节数组，用两个字节替换每个字符
     *
     * @param carr 字符数组
     * @return 字节数组
     */
    public static byte[] toRawByteArray(char[] carr) {
        if (carr == null) {
            return null;
        }

        byte[] barr = new byte[carr.length << 1];
        for (int i = 0, j = 0; i < carr.length; i++) {
            char c = carr[i];
            barr[j++] = (byte) ((c & 0xFF00) >> 8);
            barr[j++] = (byte) (c & 0x00FF);
        }
        return barr;
    }

    /**
     * 将字节数组转换为字符数组
     *
     * @param barr 字节数组
     * @return 字符数组
     */
    public static char[] toRawCharArray(byte[] barr) {
        if (barr == null) {
            return null;
        }

        int carrLen = barr.length >> 1;
        if (carrLen << 1 < barr.length) {
            carrLen++;
        }
        char[] carr = new char[carrLen];
        int i = 0, j = 0;
        while (i < barr.length) {
            char c = (char) (barr[i] << 8);
            i++;

            if (i != barr.length) {
                c += barr[i] & 0xFF;
                i++;
            }
            carr[j++] = c;
        }
        return carr;
    }

    /**
     * 使用默认UTF8编码将字符数组转换为字节数组
     *
     * @param carr 字符数组
     * @return 字节数组
     */
    public static byte[] toByteArray(char[] carr) throws UnsupportedEncodingException {
        return CharUtil.toByteArray(carr, CharsetUtil.UTF_8);
    }

    /**
     * 使用提供的编码将字符数组转换为字节数组
     *
     * @param carr    字符数组
     * @param charset 编码
     * @return 字节数组
     */
    public static byte[] toByteArray(char[] carr, String charset) throws UnsupportedEncodingException {
        if (carr == null || StringUtils.isEmpty(charset)) {
            return null;
        }
        return new String(carr).getBytes(charset);
    }

    /**
     * 将默认UTF8编码的字节数组转换为字符数组
     *
     * @param barr 字节数组
     * @return 字符数组
     */
    public static char[] toCharArray(byte[] barr) throws UnsupportedEncodingException {
        return CharUtil.toCharArray(barr, CharsetUtil.UTF_8);
    }

    /**
     * 将特定编码字节数组转换为字符数组
     *
     * @param barr    字节数组
     * @param charset 编码
     * @return 字符数组
     */
    public static char[] toCharArray(byte[] barr, String charset) throws UnsupportedEncodingException {
        if (barr == null || StringUtils.isEmpty(charset)) {
            return null;
        }

        return new String(barr, charset).toCharArray();
    }

    /**
     * 如果一个字符等于给定字符数组中的任何一个字符，则匹配
     *
     * @param c     字符
     * @param match 字符数组
     * @return 是否匹配
     */
    public static boolean equalsOne(char c, char[] match) {
        if (match == null) {
            return false;
        }
        for (char aMatch : match) {
            if (c == aMatch) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找给目标数组中匹配给定字符集中的任何一个字符的第一个字符的索引
     *
     * @param source 目标字符数组
     * @param index  从目标字符数组开始的索引
     * @param match  给定字符数组
     * @return 匹配的第一个索引
     */
    public static int findFirstEqual(char[] source, int index, char[] match) {
        if (source == null) {
            return -1;
        }
        for (int i = index; i < source.length; i++) {
            if (equalsOne(source[i], match)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找给定数组中匹配给定字符的第一个字符的索引
     *
     * @param source 目标字符数组
     * @param index  从目标字符数组开始的索引
     * @param match  给定字符
     * @return 匹配的第一个索引
     */
    public static int findFirstEqual(char[] source, int index, char match) {
        if (source == null) {
            return -1;
        }
        for (int i = index; i < source.length; i++) {
            if (source[i] == match) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找给定数组中不同于给定的字符集的第一个字符的索引
     *
     * @param source 目标字符数组
     * @param index  从目标字符数组开始的索引
     * @param match  给定字符数组
     * @return 符合条件的第一个索引
     */
    public static int findFirstDiff(char[] source, int index, char[] match) {
        if (source == null || match == null) {
            return -1;
        }
        for (int i = index; i < source.length; i++) {
            if (!equalsOne(source[i], match)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找给定数组中不同于给定的字符的第一个字符的索引
     *
     * @param source 目标字符数组
     * @param index  从目标字符数组开始的索引
     * @param match  给定字符数组
     * @return 符合条件的第一个索引
     */
    public static int findFirstDiff(char[] source, int index, char match) {
        if (source == null) {
            return -1;
        }
        for (int i = index; i < source.length; i++) {
            if (source[i] != match) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 如果字符是空格，则返回空格。空格定义是从String类（参见：trim()）获取的
     */
    public static boolean isWhitespace(char c) {
        return c <= ' ';
    }

    /**
     * 判断是否是小写字母
     *
     * @param c 给定字符
     * @return 如果指定的字符是小写的ASCII，则返回true
     */
    public static boolean isLowercaseAlpha(char c) {
        return (c >= 'a') && (c <= 'z');
    }

    /**
     * 判断是否是大写字母
     *
     * @param c 给定字符
     * @return 如果指定的字符是大写的ASCII，则返回true
     */
    public static boolean isUppercaseAlpha(char c) {
        return (c >= 'A') && (c <= 'Z');
    }

    /**
     * 判断字符是数字或者字母
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isAlphaOrDigit(char c) {
        return isDigit(c) || isAlpha(c);
    }

    /**
     * 判断字符是数字或者字母或者下划线
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isWordChar(char c) {
        return isDigit(c) || isAlpha(c) || (c == '_');
    }

    /**
     * 判断字符是数字或者字母或者下划线或者点号或者左右中括号
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isPropertyNameChar(char c) {
        return isDigit(c) || isAlpha(c) || (c == '_') || (c == '.') || (c == '[') || (c == ']');
    }

    /**
     * 判断字符是否是字母
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isAlpha(char c) {
        return ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'));
    }

    /**
     * 判断字符是否是数字
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 判断字符是否是十六进制数字
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isHexDigit(char c) {
        return (c >= '0' && c <= '9') || ((c >= 'a') && (c <= 'f')) || ((c >= 'A') && (c <= 'F'));
    }

    /**
     * 判断给定字符是否在Gen Delims集合中
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isGenericDelimiter(char c) {
        switch (c) {
            case ':':
            case '/':
            case '?':
            case '#':
            case '[':
            case ']':
            case '@':
                return true;
            default:
                return false;
        }
    }

    /**
     * 判断给定字符是否在sub-delims集合中
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isSubDelimiter(char c) {
        switch (c) {
            case '!':
            case '$':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case ';':
            case '=':
                return true;
            default:
                return false;
        }
    }

    /**
     * 判断给定字符是否在reserved集合中
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isReserved(char c) {
        return isGenericDelimiter(c) || isSubDelimiter(c);
    }

    /**
     * 判断给定字符是否在unreserved集合中
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isUnreserved(char c) {
        return isAlpha(c) || isDigit(c) || c == '-' || c == '.' || c == '_' || c == '~';
    }

    /**
     * 判断给定字符是否在pChar集合中
     *
     * @param c 给定字符
     * @return 如果指定的字符是符合条件的ASCII，则返回true
     */
    public static boolean isPChar(char c) {
        return isUnreserved(c) || isSubDelimiter(c) || c == ':' || c == '@';
    }

    /**
     * 小写字母转大写字母 提高小写字母ASCII字符
     *
     * @param c 给定字符
     * @return 如果是小写字母，则转为大写字母
     */
    public static char toUpperAscii(char c) {
        if (isLowercaseAlpha(c)) {
            c -= (char) 0x20;
        }
        return c;
    }

    /**
     * 大写字母转小写字母 降低大写字母ASCII字符
     *
     * @param c 给定字符
     * @return 如果是大写字母，则转为小写字母
     */
    public static char toLowerAscii(char c) {
        if (isUppercaseAlpha(c)) {
            c += (char) 0x20;
        }
        return c;
    }
}
