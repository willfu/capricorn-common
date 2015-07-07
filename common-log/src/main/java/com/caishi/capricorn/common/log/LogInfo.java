package com.caishi.capricorn.common.log;

public class LogInfo {

    /**
     * 日志类型名称
     */
    private String logType;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    /**
     * 日志内容对象
     */
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
