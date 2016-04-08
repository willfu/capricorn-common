package com.caishi.capricorn.common.base;

import java.io.Serializable;

public class NotifyDTO implements Serializable {

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
     * message
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}