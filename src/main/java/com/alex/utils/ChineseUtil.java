package com.alex.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 一些中文相关的操作方法
 *
 * @author alex
 * @date 2018-06-14
 */
public final class ChineseUtil {

    private ChineseUtil() {

    }

    /**
     * 将字符串中的中文转化为拼音,其他字符不变
     *
     * @param inputString 目标字符串
     * @return 将字符串中的中文转为拼音
     */
    public static String getPingYin(String inputString) {

        if (StringUtil.isEmpty(inputString)) {
            return inputString;
        }

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        char[] input = inputString.trim().toCharArray();
        StringBuilder output = new StringBuilder();

        try {
            for (char c : input) {
                if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(c, format);
                    output.append(temp[0]);
                } else {
                    output.append(c);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    /**
     * 获取汉字串拼音首字母，英文字符不变
     *
     * @param chinese 目标字符串
     * @return 字符串中的汉字转为拼音首字母
     */
    public static String getFirstSpell(String chinese) {
        if (StringUtil.isEmpty(chinese)) {
            return chinese;
        }

        StringBuilder stringBuffer = new StringBuilder();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : arr) {
            if (c > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
                    if (temp != null) {
                        stringBuffer.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString().replaceAll("\\W", "").trim();
    }

    /**
     * 获取汉字串拼音，英文字符不变
     *
     * @param chinese 目标字符串
     * @return 字符串中汉字转为拼音
     */
    public static String getFullSpell(String chinese) {
        if (StringUtil.isEmpty(chinese)) {
            return chinese;
        }

        StringBuilder stringBuffer = new StringBuilder();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : arr) {
            if (c > 128) {
                try {
                    stringBuffer.append(PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 只能判断部分CJK字符（CJK统一汉字）
     *
     * @param str 目标字符串
     * @return 判断部分CJK字符
     */
    public static boolean isChineseByREG(String str) {
        if (str == null) {
            return false;
        }
        String reg = "\\u4E00-\\u9FBF]+";
        Pattern pattern = Pattern.compile(reg);
        return pattern.matcher(str.trim()).find();
    }

    /**
     * 只能判断部分CJK字符（CJK统一汉字）
     *
     * @param str 目标字符串
     * @return 判断部分CJK字符
     */
    public static boolean isChineseByName(String str) {
        if (str == null) {
            return false;
        }
        // 大小写不同：\\p 表示包含，\\P 表示不包含
        // \\p{Cn} 的意思为 Unicode 中未被定义字符的编码，\\P{Cn} 就表示 Unicode中已经被定义字符的编码
        String reg = "\\p{InCJK Unified Ideographs}&&\\P{Cn}";
        Pattern pattern = Pattern.compile(reg);
        return pattern.matcher(str.trim()).find();
    }

    /**
     * 完整的判断中文汉字和符号
     *
     * @param strName 目标字符串
     * @return 判断中文汉字+符号
     */
    public static boolean isChinese(String strName) {
        if (StringUtil.isEmpty(strName)) {
            return false;
        }

        char[] ch = strName.toCharArray();
        for (char c : ch) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符是否是中文
     *
     * @param c 目标字符
     * @return 是否是中文
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS ||
                ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS ||
                ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A ||
                ub == Character.UnicodeBlock.GENERAL_PUNCTUATION ||
                ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION ||
                ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    /**
     * 获取一个字符串中中文字符的个数
     *
     * @param str 目标字符串
     * @return 返回中文字符的个数
     */
    public static int ChineseLength(String str) {
        String reg = "[\u4E00-\u9FA5]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        int i = 0;
        while (m.find()) {
            String temp = m.group(0);
            i += temp.length();
        }
        return i;
    }

    /**
     * 判断是否是乱码
     *
     * @param strName 目标字符串
     * @return 是否是乱码
     */
    public static boolean isMessyCode(String strName) {
        if (StringUtil.isEmpty(strName)) {
            return false;
        }

        String reg = "\\s*|\t*|\r*|\n*";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = 0;
        float count = 0;
        for (char c : ch) {
            if (!Character.isLetterOrDigit(c)) {
                if (!ChineseUtil.isChinese(c)) {
                    count = count + 1;
                }
                chLength++;
            }
        }
        float result = count / chLength;
        return result > 0.4;
    }
}
