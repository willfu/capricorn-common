package com.caishi.capricorn.common.comment.info;

import java.text.MessageFormat;
import java.util.Date;
import java.util.UUID;

public class MessageCommentInfo {

    /**
     * mongoDb _id
     */
    private String _id;

    public String get_id() {
        String val = MessageFormat.format("{0}_{1}_{2}_{3}_{4}_{5}_{6}", getMessageId(), String.valueOf(getCreateTime()), getUserId(), getDeviceId(), getDeviceType(), getOsType(), getCommentId());
        set_id(val);
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    /**
     * comment id
     */
    private String commentId = UUID.randomUUID().toString().replace("-","");

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * message id
     */
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * message type
     */
    private String messageType;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * comment content
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * user id
     */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * user nick name
     */
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * user portrait
     */
    private String portrait;

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    /**
     * device id
     */
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * device type
     */
    private String deviceType;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * os type
     */
    private String osType;

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    /**
     * create time
     */
    private long createTime = new Date().getTime();

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
