package com.caishi.capricorn.common.utils;

import java.util.regex.Pattern;

public class RegexUtil {

    public final static boolean checkNumber(String data) {
        data = data.trim();
        String regex = "^[0-9]*$";
        return Pattern.compile(regex).matcher(data).matches();
    }

    public final static boolean checkMobile(String data) {
        data = data.trim();
        return checkNumber(data) && data.length() == 11;
    }

    public final static boolean checkNumberAndChar(String data) {
        data = data.trim();
        String regex = "^[A-Za-z0-9]+$";
        return Pattern.compile(regex).matcher(data).matches();
    }

    public final static boolean checkNumberAndChar(String data, int minLen, int maxLen) {
        boolean status = checkNumberAndChar(data);
        if (status) {
            status = data.length() >= minLen && data.length() <= maxLen;
        }
        return status;
    }

    public final static boolean isMobile(String mobile) {
        boolean status = mobile != null && mobile.length() == 11;
        if (status) {
            final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,2,5-9]))\\d{8}$";
            status = Pattern.matches(REGEX_MOBILE, mobile);
        }
        return status;
    }

    public final static String trim(String data) {
        boolean status = data != null;
        if (status) {
            data = data.replaceAll(" ", "");
        }
        return data;
    }

    public static boolean isNumberString(String data) {
        data = trim(data);
        boolean status = data != null;
        if (status) {
            final String REGEX_NUMBER_STR = "^[0-9]*$";
            status = Pattern.matches(REGEX_NUMBER_STR, data);
        }
        return status;
    }
}