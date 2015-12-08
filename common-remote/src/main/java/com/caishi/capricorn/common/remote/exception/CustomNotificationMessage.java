package com.caishi.capricorn.common.remote.exception;

public class CustomNotificationMessage extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     *
     * @param code 消息编码
     */
    public CustomNotificationMessage(String code) {

        super();
        this.code = code;

    }

    /**
     * 构造函数
     *
     * @param code    消息编码
     * @param message 消息内容
     */
    public CustomNotificationMessage(String code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 消息编码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}