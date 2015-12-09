package com.caishi.capricorn.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

public class CredentialUtils {

    private CredentialUtils(){}

    /**
     * 校验用户凭证信息
     * @param credential 用户凭证
     * @return 校验是否通过
     * @throws Exception
     */
    public final static boolean checkExpireTime(String credential) throws Exception {
        credential = new String(Base64.decodeBase64(credential));
        String[] dataSource = credential.split("@");
        long timeStamp = Long.parseLong(dataSource[1]);
        Date expire = new Date(timeStamp);
        return expire.compareTo(new Date()) < 0;
    }

    /**
     * 获取用户识别信息
     * @param credential 用户凭证
     * @return 用户识别信息
     * @throws Exception
     */
    public final static String getIdentifiedString(String credential) throws Exception {
        credential = new String(Base64.decodeBase64(credential));
        String[] dataSource = credential.split("@");
        return dataSource[0];
    }

    /**
     * 获取用户凭证信息
     * @param identifiedString 用户验证字符串
     * @return 用户凭证信息
     * @throws Exception
     */
    public final static String getCredential(String identifiedString) throws Exception {
        Date now = new Date();
        now = new Date(now.getTime() + 3 * 30 * 24 * 60 * 60 * 1000);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(identifiedString);
        stringBuilder.append("@");
        stringBuilder.append(now.getTime());
        return new String(Base64.encodeBase64(stringBuilder.toString().getBytes()));
    }


    /**
     * 获取当前用户编号
     * @param credential 用户凭证信息
     * @return 用户编号
     * @throws Exception
     */
    public final static String getCurrentUserId(String credential) throws Exception {
        String identifiedString = getIdentifiedString(credential);
        return DigestUtils.md5Hex(identifiedString);
    }
}
