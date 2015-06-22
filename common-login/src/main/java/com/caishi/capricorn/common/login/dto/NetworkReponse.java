package com.caishi.capricorn.common.login.dto;

import java.io.UnsupportedEncodingException;

public class NetworkReponse<T> {

    private final String defaultMessage = "ok";

    private String code = "10000";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private String message;

    public String getMessage() throws UnsupportedEncodingException {
        return this.message != null && this.message.length() > 0 ? this.message : defaultMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Object attached;

    public Object getAttached() {
        return attached;
    }

    public void setAttached(Object attached) {
        this.attached = attached;
    }
}
