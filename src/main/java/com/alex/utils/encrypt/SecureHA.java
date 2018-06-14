package com.alex.utils.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @Deception:Secure Hash Algorithm，安全散列算法
 * @Author:Alex
 * @Date:2018年06月08日17点50分
 */
public final class SecureHA {

    public static final String KEY_SHA = "SHA";

    /**
     * 将字符串通过安全散列算法加密
     * @param inputStr
     * @return
     */
    public static String getResult(String inputStr) {
        BigInteger sha = null;
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sha.toString(32);
    }




}
