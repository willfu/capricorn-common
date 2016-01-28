package com.caishi.capricorn.common.utils;

import java.util.Random;
import java.util.UUID;

public class DataUtils {

    /**
     * 生成指定长度的随机字符串
     *
     * @param len 长度
     * @return 随机字符串
     */
    public final static String getRandomString(int len) {
        String buffer = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return getRandom(buffer, len);
    }

    /**
     * 生成指定长度的随机字符串
     *
     * @param len 长度
     * @return 随机字符串
     */
    public final static String getRandomNumber(int len) {
        String buffer = "0123456789";
        return getRandom(buffer, len);
    }

    private final static String getRandom(String buffer, int len) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < len; i++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString().trim();
    }

    /**
     * get uuid string
     * @param splitEnable split enable
     * @return uuid string
     */
    public final static String getUUIDString(boolean splitEnable) {
        String result = UUID.randomUUID().toString().toUpperCase();
        if (splitEnable) {
            result = result.replace("-", "");
        }
        return result;
    }
}