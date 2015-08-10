package com.caishi.capricorn.common.log;

import java.util.Date;

public class LogInfo {

    public LogInfo(){

    }

    /**
     * 构造函数
     * @param userId 用户编号
     * @param deviceId 设备编号
     * @param deviceType 设备类型
     * @param logType 日志类型
     */
    public LogInfo(String userId,String deviceId,String deviceType,String logType){
        this.userId = userId;
        this.deviceId=deviceId;
        this.deviceType=deviceType;
        this.logType=logType;
    }

    /**
     * 日志类型
     */
    private String logType;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    /**
     * 用户编号
     */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 设备编号
     */
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 设备类型
     */
    private String deviceType;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }


    /**
     * 日志内容
     */
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 创建时间
     */
    private long createTime = new Date().getTime();

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
