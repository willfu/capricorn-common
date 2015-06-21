package com.caishi.capricorn.common.login.data;

public enum PartnerType {

    QQ,
    WebChat,
    WeiBo,
    DouBan,
    Unknown;

    public static final String getValue(PartnerType obj) {
        String val;
        switch (obj) {
            case QQ: {
                val = "01";
                break;
            }
            case WebChat: {
                val = "02";
                break;
            }
            case WeiBo: {
                val = "03";
                break;
            }
            case DouBan: {
                val = "04";
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

    public static final PartnerType getEnum(String val) {
        val = val.trim();
        if (val.equalsIgnoreCase("00")) {
            return Unknown;
        } else if (val.equalsIgnoreCase("01")) {
            return QQ;
        } else if (val.equalsIgnoreCase("02")) {
            return WebChat;
        } else if (val.equals("03")) {
            return WeiBo;
        } else if (val.equals("04")) {
            return DouBan;
        } else {
            return null;
        }
    }

    public static final boolean validation(String val) {
        return getEnum(val) != null;
    }
}
