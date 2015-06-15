package com.caishi.capricorn.common.login.dto;

/**
 * ҵ���߼��쳣
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
     * �쳣����
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
