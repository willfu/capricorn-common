package com.caishi.capricorn.common.data.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    /**
     * 判断IP是否为内网IP
     * @param ip ip地址
     * @return 判断结果
     */
    public static boolean checkInnerIP(String ip){
        String reg = "(10|172|192)\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})";//正则表达式=。 =、懒得做文字处理了、
        Pattern p = Pattern.compile(reg);
        Matcher matcher = p.matcher(ip);
        return matcher.find();
    }
}
