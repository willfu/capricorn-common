package com.caishi.capricorn.common.login.data;

/**
 * ͨ����ע��ͨ�����¼ͨ����
 *
 * @see ͨ�������������ͨ��(Browse)���ƶ�Ӧ��ͨ��(APP)��δ֪ͨ��(Unknown)
 */
public enum Agent {

    /**
     * �������Browse��
     */
    Browse,
    /**
     * �ƶ�Ӧ�ã�APP��
     */
    App,
    /**
     * δ֪ͨ����UnKnown��
     */
    Unknown;

    /**
     * ��ȡ��ʶ��
     *
     * @param obj ͨ��ö�ٶ���
     * @return ��ʶ��
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
     * ��ȡͨ��ö�ٶ���
     *
     * @param val ͨ����ʶ��
     * @return ͨ��ö�ٶ���
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
     * У��ͨ����ʶ�����ȷ��
     *
     * @param val ͨ����ʶ��
     * @return true����֤ͨ����false����֤ʧ��
     */
    public static final boolean validation(String val) {
        return getEnum(val) != null;
    }
}
