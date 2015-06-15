package com.caishi.capricorn.common.login.data;

public enum NetType {

    /**
     * 隆岑利大(00)
     */
    UnKnown,
    /**
     * WIFI利大(01)
     */
    WIFI,
    /**
     * 2G利大(02)
     */
    G2,
    /**
     * 3G利大(03)
     */
    G3,
    /**
     * 4G利大(04)
     */
    G4;

    public static final String getValue(NetType obj) {
        String val;
        switch (obj) {
            case UnKnown: {
                val = "00";
                break;
            }
            case WIFI: {
                val = "01";
                break;
            }
            case G2: {
                val = "02";
                break;
            }
            case G3: {
                val = "03";
                break;
            }
            case G4: {
                val = "04";
                break;
            }
            default: {
                val = "00";
                break;
            }
        }
        return val;
    }

    public final static NetType getEnum(String val) {
        val = val.trim();
        if (val.equals("00")) {
            return UnKnown;
        } else if (val.equals("01")) {
            return WIFI;
        } else if (val.equals("02")) {
            return G2;
        } else if (val.equals("03")) {
            return G3;
        } else if (val.equals("04")) {
            return G4;
        } else {
            return null;
        }
    }

    public final static boolean validation(String val) {
        val = val.trim();
        return getEnum(val) != null;
    }
}