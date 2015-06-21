package com.caishi.capricorn.common.login.data;

public enum SimType {

    UnKnown,
    CMCC,
    CUCC,
    CTCC;

    public final static String getValue(SimType obj) {
        String val;
        switch (obj) {
            case UnKnown: {
                val = "00";
                break;
            }
            case CMCC: {
                val = "01";
                break;
            }
            case CUCC: {
                val = "02";
                break;
            }
            case CTCC: {
                val = "03";
                break;
            }
            default: {
                val = "00";
                break;
            }
        }
        return val;
    }

    public final static SimType getEnum(String val) {
        val = val.trim();
        if (val.equals("00")) {
            return UnKnown;
        } else if (val.equals("01")) {
            return CMCC;
        } else if (val.equals("02")) {
            return CUCC;
        } else if (val.equals("03")) {
            return CTCC;
        } else {
            return null;
        }
    }

    public final static boolean validation(String val) {
        val = val.trim();
        return getEnum(val) != null;
    }
}
