package com.alex.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Deception:封装一些正则相关的操作
 * @Author:Alex
 * @Date:2018年06月06日14点52分
 */
public final class RegUtil {
    /**
     * 字母数字字符
     */
    public static final String  REG_ALNUM               = "\\p{Alnum}";
    /**
     * 字母字符
     */
    public static final String  REG_ALPHA               = "\\p{Alpha}";
    /**
     * ASCII字符
     */
    public static final String  REG_ASCII               = "\\p{ASCII}";
    /**
     * 空格和制表符
     */
    public static final String  REG_BLANK               = "\\p{Blank}";
    /**
     * 控制字符
     */
    public static final String  REG_CNTRL               = "\\p{Cntrl}";
    /**
     * 数字
     */
    public static final String  REG_DIGITS              = "\\p{Digit}";
    /**
     * 可见字符 (比如：除了空格，控制字符等)
     */
    public static final String  REG_GRAPH               = "\\p{Graph}";
    /**
     * 小写字母
     */
    public static final String  REG_LOWER               = "\\p{Lower}";
    /**
     * 可见字符和空格 (比如：除了控制字符等。)
     */
    public static final String  REG_PRINT               = "\\p{Print}";
    /**
     * 标点符号
     */
    public static final String  REG_PUNCT               = "\\p{Punct}";
    /**
     * 所有空白空间字符，包括换行符
     */
    public static final String  REG_SPACE               = "\\p{Space}";
    /**
     * 大写字母
     */
    public static final String  REG_UPPER               = "\\p{Upper}";
    /**
     * 十六进制数字
     */
    public static final String  REG_XDIGIT              = "\\p{XDigit}";
    /**
     * 空白行
     */
    public static final String  REG_SPACE_LINE          = "\\n\\s*\\r";
    /**
     * 首尾空白字符
     */
    public static final String  REG_SPACE_POINT         = "^\\s*|\\s*$";
    /**
     * HTML
     */
    public static final String  REG_HTML                = "<(\\S*?)[^>]*>.*?</\\1>|<.*? />";
    /**
     * Email
     */
    public static final String  REG_EMAIL               = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 国内固定电话
     */
    public static final String  REG_FIXED_TELEPHONE     = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";
    /**
     * 邮政编码
     */
    public static final String  REG_POSTALCODE          = "[1-9]\\d{5}(?!\\d)";
    /**
     * 身份证编码
     */
    public static final String  REG_IDENTIFICATION_CARD = "\\d{15}|\\d{18}";
    /**
     * 银行卡号编码
     */
    public static final String  REG_BANK_CARD             = "^\\d{16,30}$";
    /**
     * 姓名
     */
    public static final String  REG_NAME                  = "^[\\u4E00-\\u9FBF][\\u4E00-\\u9FBF(.|·)]{0,13}[\\u4E00-\\u9FBF]$";
    /**
     * URL地址
     */
    public static final String  REG_URL                   = "^http://([w-]+.)+[w-]+(/[w-./?%&=]*)?$";
    /**
     * 移动电话
     */
    public static final String  REG_MOBILE_TELEPHONE    = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    /**
     * 合法的名字（字母开头，允许5-16字节，允许字母数字下划线）
     */
    public static final String  REG_LEGAL_ACCOUNT       = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
    /**
     * i地址
     */
    public static final String  REG_IP                   = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
    /**
     * 数字模式
     */
    private static      Pattern numericPattern            = Pattern.compile("^[0-9\\-]+$");
    /**
     * 数值模式
     */
    private static      Pattern numericStringPattern      = Pattern.compile("^[0-9\\-\\-]+$");
    /**
     * 浮点数模式
     */
    private static      Pattern floatNumericPattern       = Pattern.compile("^[0-9\\-\\.]+$");
    /**
     * 字母模式（包括大小写）
     */
    private static      Pattern abcPattern                = Pattern.compile("^[a-z|A-Z]+$");

    /**
     * 判断是否数字表示
     * @param src 源字符串
     * @return 是否数字的标志
     */
    public final static boolean isNumeric(String src){
        boolean result = false;
        if(StringUtils.isNotEmpty(src) && src.length() > 0){
            Matcher m = numericPattern.matcher(src);
            if(m.find()){
                result = true;
            }
        }
        return result;
    }

    /**
     * 判断是否纯字母组合
     * @param src 源字符串
     * @return 是否纯字母组合的标志
     */
    public final static boolean isABC(String src){
        boolean result = false;
        if(StringUtils.isNotEmpty(src) && src.length() > 0){
            Matcher m = abcPattern.matcher(src);
            if(m.find()){
                result = true;
            }
        }
        return result;
    }

    /**
     * 判断是否浮点数字表示
     * @param src 源字符串
     * @return 是否浮点数的标志
     */
    public final static boolean isFloatNumeric(String src) {
        boolean result = false;
        if (StringUtils.isNotEmpty(src) && src.length() > 0) {
            Matcher m = floatNumericPattern.matcher(src);
            if (m.find()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * 判断字符串str是否符合正则表达式reg
     * @param str 需要处理的字符串
     * @param reg 正则表达式
     * @return 是否匹配
     */
    public final static boolean isMatche(String str, String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher isMatche   = pattern.matcher(str);
        return isMatche.matches();
    }

    /**
     * 获取符合reg正则表达式的字符串在String中出现的次数
     * @param str 需要处理的字符串
     * @param reg 正则表达式
     * @return 出现的次数
     */
    public final static int countSubStrReg(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        int     i = 0;
        while (m.find()) {
            i++;
        }
        return i;
    }

    /**
     * 验证邮箱是否有效
     * @param email 要验证的邮箱
     * @return 是否是正确的邮箱
     */
    public final static boolean validateEmail(String email) {
        if (StringUtils.isEmpty(email) || email.length() < 1 || email.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile(REG_EMAIL);
        return pattern.matcher(email).matches();
    }

    /**
     * 验证手机是否有效
     * @param mobile 要验证的手机号
     * @return 是否是正确的手机号
     */
    public final static boolean validateMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Pattern pattern = Pattern.compile(REG_MOBILE_TELEPHONE);
        return pattern.matcher(mobile).matches();
    }

    /**
     * 验证固定电话是否有效
     * @param tel 要判断的电话
     * @return 是否是正确的固定电话
     */
    public final static boolean validateTel(String tel){
        if(StringUtils.isEmpty(tel)){
            return false;
        }
        Pattern pattern = Pattern.compile(REG_FIXED_TELEPHONE);
        return pattern.matcher(tel).matches();
    }

    /**
     * 验证姓名是否有效
     * @param name 要验证的姓名
     * @return 是否是正确的姓名
     */
    public static boolean validateName(String name) {
        if (StringUtils.isEmpty(name) || name.replaceAll("[^.·]", "").length() > 1) {
            return false;
        }
        Pattern pattern = Pattern.compile(REG_NAME);
        return pattern.matcher(name).matches();
    }

    /**
     * 验证身份证是否有效
     * @param idCardNumber 要验证的身份证
     * @return 是否正确身份证
     */
    public static boolean validateIdCard(String idCardNumber) {
        if (StringUtils.isEmpty(idCardNumber)) {
            return false;
        }
        Pattern pattern = Pattern.compile(REG_IDENTIFICATION_CARD);
        return pattern.matcher(idCardNumber).matches();
    }

    /**
     * 验证银行卡是否有效
     * @param bankCardNumber 要验证的银行卡号
     * @return 是否正确银行卡号
     */
    public static boolean validateBankCardNumber(String bankCardNumber) {
        if (StringUtils.isEmpty(bankCardNumber)) {
            return false;
        }
        Pattern pattern = Pattern.compile(REG_BANK_CARD);
        return pattern.matcher(bankCardNumber).matches();
    }

    /**
     * 验证邮编是否有效
     * @param postalCode 要验证的邮编
     * @return 是否正确的邮编
     */
    public static boolean validatePostalCode(String postalCode){
        if (StringUtils.isEmpty(postalCode)) {
            return false;
        }
        Pattern pattern = Pattern.compile(REG_POSTALCODE);
        return pattern.matcher(postalCode).matches();
    }
}
