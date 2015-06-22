package com.caishi.capricorn.common.login.data;

public enum CreateMode {

    Automatic,
    Human,
    Partner,
    Unknown;

    public static final String getValue(CreateMode obj) {
        String val;
        switch (obj) {
            case Human: {
                val = "01";
                break;
            }
            case Automatic: {
                val = "02";
                break;
            }
            case Partner: {
                val = "03";
                break;
            }
            case Unknown: {
                val = "00";
                break;
            }
            default: {
                val = "00";
                break;
            }
        }
        return val;
    }

    public static final CreateMode getEnum(String val) {
        val = val.trim();
        if (val.equalsIgnoreCase("00")) {
            return Unknown;
        } else if (val.equalsIgnoreCase("01")) {
            return Human;
        } else if (val.equalsIgnoreCase("02")) {
            return Automatic;
        } else if (val.equalsIgnoreCase("03")) {
            return Partner;
        } else {
            return null;
        }
    }

    public static boolean validation(String val) {
        return getEnum(val) != null;
    }
}
