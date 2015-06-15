package com.caishi.capricorn.common.login.dto;

/**
 * 业务逻辑异常
 */
public class CustomMessage extends Exception {

    private static final long serialVersionUID = 1L;

    public CustomMessage(String code) {
        
        super();
        this.code = code;

    }

    public CustomMessage(String code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 异常编码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
