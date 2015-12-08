package com.caishi.capricorn.common.remote.result;

import java.util.Date;
import java.util.UUID;

public class ServiceResponse<T> {

    /**
     * 请求编号
     */
    private String requestId = UUID.randomUUID().toString();

    public String getRequestId() {
        return requestId;
    }

    /**
     * 请求开始时间
     */
    private long requestStartTime = new Date().getTime();

    public long getRequestStartTime() {
        return requestStartTime;
    }

    /**
     * 请求结束时间
     */
    private long requestEndTime;

    public long getRequestEndTime() {
        return requestEndTime;
    }

    /**
     * 相应代码
     */
    private String code = "10000";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 消息内容
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.requestEndTime = new Date().getTime();
        this.data = data;
    }

    /**
     * 交互消息
     */
    private String message = "ok";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 附加信息
     */
    private Object attached;

    public Object getAttached() {
        return attached;
    }

    public void setAttached(Object attached) {
        this.requestEndTime = new Date().getTime();
        this.attached = attached;
    }
}