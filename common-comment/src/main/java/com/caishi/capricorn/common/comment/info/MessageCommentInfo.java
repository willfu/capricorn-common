package com.caishi.capricorn.common.comment.info;

import com.caishi.capricorn.common.comment.constants.AuditLevel;
import com.caishi.capricorn.common.comment.constants.AuditStatus;
import com.caishi.capricorn.common.comment.constants.CommentLevel;
import com.caishi.capricorn.common.comment.constants.CommentStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MessageCommentInfo implements Serializable {

    /**
     * comment id {mongoDb _id}
     */
    private String id = UUID.randomUUID().toString().replace("-", "");

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    /**
     * modifyTime
     */
    private long modifyTime = new Date().getTime();

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * audit level
     */
    private AuditLevel auditLevel = AuditLevel.MONITOR;

    public AuditLevel getAuditLevel() {
        return auditLevel;
    }

    public void setAuditLevel(AuditLevel auditLevel) {
        this.auditLevel = auditLevel;
    }

    /**
     * comment status
     */
    private CommentStatus commentStatus = CommentStatus.ONLINE;

    public CommentStatus getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(CommentStatus commentStatus) {
        this.commentStatus = commentStatus;
    }

    /**
     * comment level
     */
    private CommentLevel commentLevel;

    public CommentLevel getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(CommentLevel commentLevel) {
        this.commentLevel = commentLevel;
    }

    /**
     * audit status
     */
    private AuditStatus auditStatus = AuditStatus.UNDONE;

    public AuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * reviewer
     */
    private String reviewer;

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * forbidden words filter result
     */
    private List<String> forbiddenWordList = new ArrayList<String>();

    public List<String> getForbiddenWordList() {
        return forbiddenWordList;
    }

    public void setForbiddenWordList(List<String> forbiddenWordList) {
        this.forbiddenWordList = forbiddenWordList;
    }

    /**
     * sensitive word filter result
     */
    private List<String> sensitiveWordList = new ArrayList<String>();

    public List<String> getSensitiveWordList() {
        return sensitiveWordList;
    }

    public void setSensitiveWordList(List<String> sensitiveWordList) {
        this.sensitiveWordList = sensitiveWordList;
    }

    /**
     * message comment info top status
     */
    private boolean topStatus = false;

    public boolean isTopStatus() {
        return topStatus;
    }

    public void setTopStatus(boolean topStatus) {
        this.topStatus = topStatus;
    }

    /**
     * message comment info picked status
     */
    private boolean pickedStatus = false;

    public boolean isPickedStatus() {
        return pickedStatus;
    }

    public void setPickedStatus(boolean pickedStatus) {
        this.pickedStatus = pickedStatus;
    }

    /**
     * message comment info hot status
     */
    private boolean hotStatus = false;

    public boolean isHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(boolean hotStatus) {
        this.hotStatus = hotStatus;
    }
}