package com.caishi.capricorn.common.data;

public class RegexUtil {

    /**
     * 判断数据是否为合法的IP地址
     * @param val 数据
     * @return 是否为合法的IP地址
     */
    public final static boolean makeValidatorForIP(String val){
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        boolean status = val.matches(regex);
        return status;
    }
}
