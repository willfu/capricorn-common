package com.caishi.capricorn.common.remote.dto;

public class NotifyInfo extends Exception {

    /**
     * notify info
     */
    private volatile static NotifyInfo notifyInfo = getInstance();

    /**
     * get notify info instance
     *
     * @return notify info instance
     */
    private final static NotifyInfo getInstance() {
        if (notifyInfo == null) {
            synchronized (NotifyInfo.class) {
                NotifyInfo temp = notifyInfo;
                if (temp == null) {
                    temp = new NotifyInfo();
                    notifyInfo = temp;
                }
            }
        }
        return notifyInfo;
    }

    /**
     * get notify info instance
     *
     * @param code code
     * @return notify info instance
     */
    public final static NotifyInfo info(String code) {
        notifyInfo.setCode(code);
        notifyInfo.setInfo(null);
        return notifyInfo;
    }

    /**
     * get notify info instance
     *
     * @param code code
     * @param info info
     * @return notify info instance
     */
    public final static NotifyInfo info(String code, String info) {
        notifyInfo.setCode(code);
        notifyInfo.setInfo(info);
        return notifyInfo;
    }

    /**
     * code
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * info
     */
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}