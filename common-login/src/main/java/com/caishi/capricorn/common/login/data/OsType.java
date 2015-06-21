package com.caishi.capricorn.common.login.data;

public enum OsType {

    Unknown,
    Android,
    IOS,
    Mac,
    Window,
    WinPhone;

    public static final String getValue(OsType obj) {
        String val;
        switch (obj) {
            case Unknown: {
                val = "00";
                break;
            }
            case Android: {
                val = "01";
                break;
            }
            case IOS: {
                val = "02";
                break;
            }
            case Mac: {
                val = "03";
                break;
            }
            case Window: {
                val = "04";
                break;
            }
            case WinPhone: {
                val = "05";
                break;
            }
            default: {
                val = "00";
                break;
            }
        }
        return val;
    }

    public final static OsType getEnum(String val) {
        val = val.trim();
        if (val.equalsIgnoreCase("00")) {
            return Unknown;
        } else if (val.equalsIgnoreCase("01")) {
            return Android;
        } else if (val.equalsIgnoreCase("02")) {
            return IOS;
        } else if (val.equals("03")) {
            return Mac;
        } else if (val.equalsIgnoreCase("04")) {
            return Window;
        } else if (val.equalsIgnoreCase("05")) {
            return WinPhone;
        } else {
            return null;
        }
    }

    public static final boolean validation(String val) {
        return getEnum(val) != null;
    }
}
