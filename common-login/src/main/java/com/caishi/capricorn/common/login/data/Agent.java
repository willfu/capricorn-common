package com.caishi.capricorn.common.login.data;

/**
 * 通道（注册通道与登录通道）
 *
 * @see 通道包括：浏览器通道(Browse)，移动应用通道(APP)及未知通道(Unknown)
 */
public enum Agent {

    /**
     * 浏览器（Browse）
     */
    Browse,
    /**
     * 移动应用（APP）
     */
    App,
    /**
     * 未知通道（UnKnown）
     */
    Unknown;

    /**
     * 获取标识码
     *
     * @param obj 通道枚举对象
     * @return 标识码
     */
    public static String getValue(Agent obj) {
        String val;
        switch (obj) {
            case App: {
                val = "S";
                break;
            }
            case Browse: {
                val = "B";
                break;
            }
            case Unknown: {
                val = "U";
                break;
            }
            default: {
                val = "U";
                break;
            }
        }
        return val;
    }

    /**
     * 获取通道枚举对象
     *
     * @param val 通道标识码
     * @return 通道枚举对象
     */
    public static final Agent getEnum(String val) {
        val = val.trim().toUpperCase();
        if (val.equalsIgnoreCase("B")) {
            return Browse;
        } else if (val.equalsIgnoreCase("S")) {
            return App;
        } else if (val.equalsIgnoreCase("U")) {
            return Unknown;
        } else {
            return null;
        }
    }

    /**
     * 校验通道标识码的正确性
     *
     * @param val 通道标识码
     * @return true：验证通过；false：验证失败
     */
    public static final boolean validation(String val) {
        return getEnum(val) != null;
    }
}
