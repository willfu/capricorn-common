package com.caishi.capricorn.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.MessageFormat;
import java.util.Date;

public class CredentialUtils {

    private final static String splicer = "@";

    private final static long expireMilSeconds = 3 * 30 * 24 * 60 * 60 * 1000;

    /**
     * 校验用户凭证信息
     *
     * @param credential 用户凭证
     * @return 校验是否通过
     * @throws Exception
     */
    public final static boolean checkExpireTime(String credential) throws Exception {
        boolean status = false;
        if (credential != null && !credential.isEmpty()) {
            credential = new String(Base64.decodeBase64(credential));
            String[] dataSource = credential.split(splicer);
            if (dataSource != null && dataSource.length == 2) {
                Date expireTime = new Date(Long.parseLong(dataSource[1]));
                status = expireTime.compareTo(new Date()) < 0;
            }
        }
        return status;
    }

    /**
     * 获取用户识别信息
     *
     * @param credential 用户凭证
     * @return 用户识别信息
     * @throws Exception
     */
    public final static String getIdentifiedString(String credential) throws Exception {
        String identified = null;
        if (credential != null && !credential.isEmpty()) {
            credential = new String(Base64.decodeBase64(credential));
            String[] dataSource = credential.split(splicer);
            if (dataSource != null && dataSource.length == 2) {
                identified = dataSource[0];
            }
        }
        return identified;
    }

    /**
     * 获取用户凭证信息
     *
     * @param identifiedString 用户验证字符串
     * @return 用户凭证信息
     * @throws Exception
     */
    public final static String getCredential(String identifiedString) throws Exception {
        String credential = null;
        if (identifiedString != null && !identifiedString.isEmpty()) {
            credential = MessageFormat.format("{0}{1}{2}", identifiedString, splicer, String.valueOf(new Date().getTime() + expireMilSeconds));
        }
        if (credential != null && !credential.isEmpty()) {
            credential = new String(Base64.encodeBase64(credential.getBytes()));
        }
        return credential;
    }


    /**
     * 获取当前用户编号
     *
     * @param credential 用户凭证信息
     * @return 用户编号
     * @throws Exception
     */
    public final static String getCurrentUserId(String credential) throws Exception {
        String userId = null;
        String identifiedString = getIdentifiedString(credential);
        if (identifiedString != null && !identifiedString.isEmpty()) {
            userId = DigestUtils.md5Hex(identifiedString);
        }
        return userId;
    }
}