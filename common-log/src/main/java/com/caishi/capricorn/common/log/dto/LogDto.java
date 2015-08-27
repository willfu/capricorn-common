package com.caishi.capricorn.common.log.dto;

import java.util.HashMap;
import java.util.Map;

public class LogDto {

    /**
     * 日志片段
     */
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 事件名称
     */
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * 事件事件
     */
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    /**
     * 作用范围
     */
    private String page;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    /**
     * 日志参数
     */
    private Map<String,Object> param = new HashMap<String, Object>();

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    /**
     * 位置信息
     */
    private Map<String,Double> position = new HashMap<String,Double>();

    public Map<String, Double> getPosition() {
        return position;
    }

    public void setPosition(Map<String, Double> position) {
        this.position = position;
    }
}
