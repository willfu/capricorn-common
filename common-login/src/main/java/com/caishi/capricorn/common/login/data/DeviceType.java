package com.caishi.capricorn.common.login.data;

public enum DeviceType {

    Unknown,
    Mobile,
    Tablet,
    Computer;

    public static final String getValue(DeviceType obj) {
        String val = "00";
        switch (obj) {
            case Mobile: {
                val = "01";
                break;
            }
            case Tablet: {
                val = "02";
                break;
            }
            case Computer: {
                val = "03";
                break;
            }
            case Unknown: {
                val = "00";
                break;
            }
        }
        return val;
    }

    public static final DeviceType getEnum(String val) {
        val = val.trim();
        if (val.equalsIgnoreCase("00")) {
            return Unknown;
        } else if (val.equalsIgnoreCase("01")) {
            return Mobile;
        } else if (val.equalsIgnoreCase("02")) {
            return Tablet;
        } else if (val.equalsIgnoreCase("03")) {
            return Computer;
        } else {
            return null;
        }
    }

    public static final boolean validation(String val) {
        return getEnum(val) != null;
    }
}
