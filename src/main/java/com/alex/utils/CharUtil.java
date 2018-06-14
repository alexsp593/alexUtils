package com.alex.utils;

import java.io.UnsupportedEncodingException;

/**
 * @Deception:各种字符和字符序列实用程序包括字符数组、字节数组转换。
 * @Author:Alex
 * @Date:2018年06月14日09点47分
 */
public final class CharUtil {


    /**
     * 将有符号的字节转换为无符号的字符
     */
    public static char toChar(byte b) {
        return (char) (b & 0xFF);
    }

    /**
     * 通过剥离每个字符的高位字节，将字符数组转换为字节数组
     */
    public final static byte[] toSimpleByteArray(char[] carr) {
        byte[] barr = new byte[carr.length];
        for (int i = 0; i < carr.length; i++) {
            barr[i] = (byte) carr[i];
        }
        return barr;
    }

    /**
     * 将字符序列转换为字节数组
     */
    public final static byte[] toSimpleByteArray(CharSequence charSequence) {
        byte[] barr = new byte[charSequence.length()];
        for (int i = 0; i < barr.length; i++) {
            barr[i] = (byte) charSequence.charAt(i);
        }
        return barr;
    }

    /**
     * 将字节数组转换为字符数组，将字节数组转换为字符数组
     */
    public final static char[] toSimpleCharArray(byte[] barr) {
        char[] carr = new char[barr.length];
        for (int i = 0; i < barr.length; i++) {
            carr[i] = (char) (barr[i] & 0xFF);
        }
        return carr;
    }

    /**
     * 返回字符的ASCII值。在过载情况下，返回0x3f
     */
    public final static int toAscii(char c) {
        if (c <= 0xFF) {
            return c;
        } else {
            return 0x3F;
        }
    }

    /**
     * 将字符数组转换为{@ Link LyToTasCII（CHAR）ASCII}数组
     */
    public final static byte[] toAsciiByteArray(char[] carr) {
        byte[] barr = new byte[carr.length];
        for (int i = 0; i < carr.length; i++) {
            barr[i] = (byte) ((int) (carr[i] <= 0xFF ? carr[i] : 0x3F));
        }
        return barr;
    }

    /**
     * 将字符序列转换为ASCII字节数组
     */
    public final static byte[] toAsciiByteArray(CharSequence charSequence) {
        byte[] barr = new byte[charSequence.length()];
        for (int i = 0; i < barr.length; i++) {
            char c = charSequence.charAt(i);
            barr[i] = (byte) ((int) (c <= 0xFF ? c : 0x3F));
        }
        return barr;
    }

    /**
     * 将字符数组转换为字节数组，用两个字节替换每个字符
     */
    public final static byte[] toRawByteArray(char[] carr) {
        byte[] barr = new byte[carr.length << 1];
        for (int i = 0, bpos = 0; i < carr.length; i++) {
            char c = carr[i];
            barr[bpos++] = (byte) ((c & 0xFF00) >> 8);
            barr[bpos++] = (byte) (c & 0x00FF);
        }
        return barr;
    }

    /**
     * 将字节数组转换为字符数组
     */
    public final static char[] toRawCharArray(byte[] barr) {
        int carrLen = barr.length >> 1;
        if (carrLen << 1 < barr.length) {
            carrLen++;
        }
        char[] carr = new char[carrLen];
        int    i    = 0, j = 0;
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
     * 使用默认JoDD编码将字符数组转换为字节数组
     */
    public final static byte[] toByteArray(char[] carr) throws UnsupportedEncodingException {
        return new String(carr).getBytes(CharsetUtil.UTF_8);
    }

    /**
     * 使用提供的编码将字符数组转换为字节数组
     */
    public final static byte[] toByteArray(char[] carr, String charset) throws UnsupportedEncodingException {
        return new String(carr).getBytes(charset);
    }

    /**
     * 将默认JoDD编码的字节数组转换为字符数组
     */
    public final static char[] toCharArray(byte[] barr) throws UnsupportedEncodingException {
        return new String(barr, CharsetUtil.UTF_8).toCharArray();
    }

    /**
     * 将特定编码字节数组转换为字符数组
     */
    public final static char[] toCharArray(byte[] barr, String charset) throws UnsupportedEncodingException {
        return new String(barr, charset).toCharArray();
    }

    /**
     * 如果一个字符等于给定字符中的任何一个字符，则匹配
     */
    public final static boolean equalsOne(char c, char[] match) {
        for (char aMatch : match) {
            if (c == aMatch) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找给定数组中第一个字符的索引，匹配给定字符集中的任何一个字符
     */
    public final static int findFirstEqual(char[] source, int index, char[] match) {
        for (int i = index; i < source.length; i++) {
            if (equalsOne(source[i], match) == true) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找给定数组中第一个字符的索引，匹配给定字符集中的任何一个字符。
     */
    public final static int findFirstEqual(char[] source, int index, char match) {
        for (int i = index; i < source.length; i++) {
            if (source[i] == match) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找给定数组中第一个字符的索引，不同于给定的字符集
     */
    public final static int findFirstDiff(char[] source, int index, char[] match) {
        for (int i = index; i < source.length; i++) {
            if (equalsOne(source[i], match) == false) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找给定数组中第一个字符的索引，不同于给定的字符集
     */
    public final static int findFirstDiff(char[] source, int index, char match) {
        for (int i = index; i < source.length; i++) {
            if (source[i] != match) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 如果字符是空格（{@代码<＝`}）），则返回空格（{@代码<＝`}）。空格定义是从String类（参见：trim()）获取的。
     */
    public final static boolean isWhitespace(char c) {
        return c <= ' ';
    }

    /**
     * 如果指定的字符是小写的ASCII，则返回true。
     * 如果用户只使用ASCIIs，则要快得多
     */
    public final static boolean isLowercaseAlpha(char c) {
        return (c >= 'a') && (c <= 'z');
    }

    /**
     * 如果指定的字符是大写的ASCII，则返回true。
     * 如果用户只使用ASCIIs，则要快得多。
     */
    public final static boolean isUppercaseAlpha(char c) {
        return (c >= 'A') && (c <= 'Z');
    }

    public final static boolean isAlphaOrDigit(char c) {
        return isDigit(c) || isAlpha(c);
    }

    public final static boolean isWordChar(char c) {
        return isDigit(c) || isAlpha(c) || (c == '_');
    }

    public final static boolean isPropertyNameChar(char c) {
        return isDigit(c) || isAlpha(c) || (c == '_') || (c == '.') || (c == '[') || (c == ']');
    }

    /**
     * 指示给定字符是否在{@代码alpha }集合中。
     */
    public final static boolean isAlpha(char c) {
        return ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'));
    }

    /**
     * 指示给定字符是否在{@代码位数}集合中。
     */
    public final static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 指示给定字符是否为十六进制数字
     */
    public final static boolean isHexDigit(char c) {
        return (c >= '0' && c <= '9') || ((c >= 'a') && (c <= 'f')) || ((c >= 'A') && (c <= 'F'));
    }

    /**
     * 指示给定字符是否在Gen Delims集合中。
     */
    public final static boolean isGenericDelimiter(int c) {
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
     * 指示给定字符是否在sub-delims集合中。
     */
    public final static boolean isSubDelimiter(int c) {
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
     * 指示给定字符是否在reserved集合中。
     */
    public final static boolean isReserved(char c) {
        return isGenericDelimiter(c) || isSubDelimiter(c);
    }

    /**
     * 指示给定字符是否在unreserved集合中。
     */
    public final static boolean isUnreserved(char c) {
        return isAlpha(c) || isDigit(c) || c == '-' || c == '.' || c == '_' || c == '~';
    }

    /**
     * 指示给定字符是否在pChar集合中。
     */
    public final static boolean isPchar(char c) {
        return isUnreserved(c) || isSubDelimiter(c) || c == ':' || c == '@';
    }

    /**
     * 提高小写字母ASCII字符.
     */
    public final static char toUpperAscii(char c) {
        if (isLowercaseAlpha(c)) {
            c -= (char) 0x20;
        }
        return c;
    }

    /**
     * 降低大写字母ASCII字符
     */
    public final static char toLowerAscii(char c) {
        if (isUppercaseAlpha(c)) {
            c += (char) 0x20;
        }
        return c;
    }
}
