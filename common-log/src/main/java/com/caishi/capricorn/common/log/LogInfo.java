package com.caishi.capricorn.common.log;

import com.caishi.capricorn.common.base.MessageType;
import com.caishi.capricorn.common.log.meta.ReferentType;

import java.util.Date;

public class LogInfo {

    public LogInfo() {

    }

    /**
     * 构造函数
     *
     * @param messageId    消息编号
     * @param messageType  消息类型
     * @param referentId   来源编号
     * @param referentType 来源类型
     * @param userId       用户编号
     * @param deviceId     设备编号
     * @param deviceType   设备类型
     * @param logType      日志类型
     */
    public LogInfo(String messageId, MessageType messageType, String referentId, ReferentType referentType, String userId, String deviceId, String deviceType, String logType) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.logType = logType;
    }

    /**
     * topic name
     */
    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * 消息编号
     */
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * 消息来源
     */
    private MessageType messageType;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    /**
     * 来源类型
     */
    private ReferentType referentType;

    public ReferentType getReferentType() {
        return referentType;
    }

    public void setReferentType(ReferentType referentType) {
        this.referentType = referentType;
    }

    /**
     * 来源编号
     */
    private String referentId;

    public String getReferentId() {
        return referentId;
    }

    public void setReferentId(String referentId) {
        this.referentId = referentId;
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
     * 软件版本
     */
    private String app;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
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
