package com.caishi.capricorn.common.login.data;

public enum Agent {

    Browse,
    App,
    Unknown;

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

    public static final boolean validation(String val) {
        return getEnum(val) != null;
    }
}
